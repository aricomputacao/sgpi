package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import br.com.sgpi.logistica.util.Util;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntregadorServiceIT {

    @Autowired
    private EntregadorService entregadorService;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Mock
    private EntregadorMapper entregadorMapper;

    @Test
    @Order(1)
    void devePermitirCriarTabela() {
        var totalRegistros = entregadorRepository.count();
        assertThat(totalRegistros).isNotNegative();
    }

    @Nested
    @DisplayName("Deve testar o cadastro e desativação do entregador")
    class ManterEntregadorTeste {

        @Test
        void deveCadastrarEntregador() {
            //arrange
            EntregadorDto entregadorDto = Util.gerarEntregadorDto();

            //action
            EntregadorDto resultado = entregadorService.salvar(entregadorDto);

            //assert
            assertThat(entregadorRepository.findById(resultado.id())).isPresent();
        }

        @Test
        @Sql(scripts = "/data_entregador.sql") // SQL para inserir dados no banco antes do teste
        void deveDesativarEntregadorNoBanco() {
            // Arrange
            EntregadorDto entregadorDto = Util.gerarEntregadorDto();
            EntregadorDto resultado = entregadorService.salvar(entregadorDto);
            // Act
              entregadorService.desativar(resultado.id());

            // Assert
            Entregador entregador = entregadorRepository.findById(resultado.id()).orElseThrow();
            assertFalse(entregador.isAtivo());
        }

        @Test
        void deveLancarExcecaoSeEntregadorNaoExistir() {
            // Arrange
            Long idInexistente = 999L;

            // Act & Assert
            RegraDeNegocioException exception = assertThrows(
                    RegraDeNegocioException.class,
                    () -> entregadorService.desativar(idInexistente)
            );
            assertEquals("Entregador com id " + idInexistente + " não encontrado", exception.getMessage());
        }
    }

    @Test
    void deveRetornarEntregadoresDoBanco() {
        // Arrange
        EntregadorDto entregadorDto = Util.gerarEntregadorDto();
        entregadorService.salvar(entregadorDto);
        Pageable pageable = PageRequest.of(0, 10);

        // Act
        Page<EntregadorDto> entregadores = entregadorService.consultarTodos(pageable);

        // Assert
        assertNotNull(entregadores);
        assertFalse(entregadores.isEmpty());
    }
}
