package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.util.Util;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(scripts = {"/clean.sql",
        "/data_entregador.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class EntregadorRepositoryIT {

    @Autowired
    private EntregadorRepository entregadorRepository;

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
        @Order(2)
        void deveCadastrarEntregador() {

            //arrange
            var entregador = Util.gerarEntregador();

            //act
            var entregadorSalvo = entregadorRepository.save(entregador);

            //assert
            assertThat(entregadorSalvo)
                    .isInstanceOf(Entregador.class)
                    .isNotNull()
                    .isEqualTo(entregador);
            assertThat(entregadorSalvo).extracting(Entregador::getId).isEqualTo(entregador.getId());
            assertThat(entregadorSalvo).extracting(Entregador::getNome).isEqualTo(entregador.getNome());
        }

        @Test
        @Order(3)
        void deveDesativarEntregador() {

            //arrange
            var entregador = Util.gerarEntregador();

            //act
            entregador.desativar();
            var entregadorSalvo = entregadorRepository.save(entregador);

            //assert
            assertThat(entregadorSalvo)
                    .isInstanceOf(Entregador.class)
                    .isNotNull()
                    .isEqualTo(entregador);
            assertThat(entregadorSalvo).extracting(Entregador::getStatusEntregador)
                    .isEqualTo(StatusEntregador.DESATIVADO);
        }
    }

    @Nested
    @DisplayName("Deve testar a consulta de entregadores.")
    class ConsultarEntregadoresTeste {

        @Test
        @Order(4)
        void deveConsultarUmEntregadore() {
            //arrange
            var entregador = registrarEntregador();
            Long id = entregador.getId();

            //act
            Optional<Entregador> entregadorSalvo = entregadorRepository.findById(id);

            //assert
            assertThat(entregadorSalvo).isNotEmpty();
            assertThat(entregadorSalvo.get().getId()).isEqualTo(id);
            assertThat(entregadorSalvo.get().getNome()).isEqualTo(entregador.getNome());
        }

        @Test
        void deveConsultarEntregadores(){
            assertThatCode(() -> {
                var resultado = entregadorRepository.findAll();
                assertThat(resultado).isInstanceOf(List.class);
            }).doesNotThrowAnyException();
        }
    }

    private Entregador registrarEntregador() {
        Entregador entregador = Util.gerarEntregador();
        return entregadorRepository.save(entregador);

    }
}
