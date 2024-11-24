package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import br.com.sgpi.logistica.util.Util;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntregadorServiceTest {

    @InjectMocks
    private EntregadorService entregadorService;

    @Mock
    private EntregadorMapper entregadorMapper;

    @Mock
    private EntregadorRepository entregadorRepository;

    @Mock
    private Entregador entregador;

    @Mock
    private EntregadorDto entregadorDto;

    @Mock
    private Validator validator;

    @BeforeEach
    void setUp() {
        // Inicializa um Validator real, baseado na implementação padrão
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Nested
    @DisplayName("Deve testar o cadastro e desativação do entregador")
    class ManterEntregadorTeste {

        @Test
        void naoDeveCadastrarEntregadorComNomeInvalido() {
            //arrange
            Entregador entregador = Util.gerarEntregador();
            entregador.setNome(null);

            //act+assert
            Assertions.assertTrue(checarExceptionNomeCampo("nome", entregador));

        }

        @Test
        void deveSalvarEntregadorERetornarDto() {
            // Arrange
            EntregadorDto entregadorDto = EntregadorDto.builder().build();
            Entregador entregador = new Entregador();
            Entregador entregadorSalvo = new Entregador();
            EntregadorDto entregadorDtoSalvo = EntregadorDto.builder().build();

            when(entregadorMapper.dtoToEntity(entregadorDto)).thenReturn(entregador);
            when(entregadorRepository.save(entregador)).thenReturn(entregadorSalvo);
            when(entregadorMapper.entityToDto(entregadorSalvo)).thenReturn(entregadorDtoSalvo);

            // Act
            EntregadorDto resultado = entregadorService.salvar(entregadorDto);

            // Assert
            assertNotNull(resultado);
            assertEquals(entregadorDtoSalvo, resultado);
            verify(entregadorMapper).dtoToEntity(entregadorDto);
            verify(entregadorRepository).save(entregador);
            verify(entregadorMapper).entityToDto(entregadorSalvo);
        }

        @Test
        void deveDesativarEntregadorExistente() {
            // Arrange
            Long id = 1L;
            Entregador entregador = mock(Entregador.class);
            when(entregadorRepository.findById(id)).thenReturn(Optional.of(entregador));

            // Act
            entregadorService.desativar(id);

            // Assert
            verify(entregadorRepository).findById(id);
            verify(entregador).desativar();
            verify(entregadorRepository).save(entregador);
        }

        @Test
        void deveLancarExcecaoSeEntregadorNaoExistir() {
            // Arrange
            Long id = 1L;
            when(entregadorRepository.findById(id)).thenReturn(Optional.empty());

            // Act & Assert
            RegraDeNegocioException exception = assertThrows(
                    RegraDeNegocioException.class,
                    () -> entregadorService.desativar(id)
            );
            assertEquals("Entregador com id " + id + " não encontrado", exception.getMessage());
            verify(entregadorRepository).findById(id);
            verifyNoMoreInteractions(entregadorRepository);
        }
    }

    @Test
    void deveRetornarListaDeEntregadores() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        Entregador entregador = new Entregador();
        EntregadorDto entregadorDto =  EntregadorDto.builder().build();
        Page<Entregador> pageEntregadores = new PageImpl<>(Collections.singletonList(entregador));

        when(entregadorRepository.findAll(pageable)).thenReturn(pageEntregadores);
        when(entregadorMapper.entityToDto(entregador)).thenReturn(entregadorDto);

        // Act
        Page<EntregadorDto> resultado = entregadorService.consultarTodos(pageable);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getTotalElements());
        assertEquals(entregadorDto, resultado.getContent().get(0));
        verify(entregadorRepository).findAll(pageable);
        verify(entregadorMapper).entityToDto(entregador);
    }

    private boolean checarExceptionNomeCampo(String nomeCampo, Entregador entregador) {
        for (ConstraintViolation<Entregador> violation : validator.validate(entregador)) {
            if (violation.getPropertyPath().toString().equals(nomeCampo)) {
                return true;
            }
        }
        return false;
    }
}