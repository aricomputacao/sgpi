package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.Veiculo;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EntregadorRepositoryTest {

    @Mock
    private EntregadorRepository entregadorRepository;

    @Nested
    @DisplayName("Deve testar o cadastro e desativação do entregador")
    class ManterEntregadorTeste {

        @Test
        void deveCadastrarUmEntregador() {

            //arrange
            var entregador = Util.gerarEntregador();
            Mockito.when(entregadorRepository.save(Mockito.any(Entregador.class))).thenReturn(entregador);

            //act
            var entregadorSalvo = entregadorRepository.save(entregador);

            //assert
            verify(entregadorRepository, times(1)).save(Mockito.any(Entregador.class));
            assertThat(entregadorSalvo).isInstanceOf(Entregador.class).isNotNull().isEqualTo(entregador);

            assertThat(entregadorSalvo).extracting(Entregador::getId).isEqualTo(entregador.getId());

            assertThat(entregadorSalvo).extracting(Entregador::getNome).isEqualTo(entregadorSalvo.getNome());

        }

        @Test
        void deveDesativarUmEntregador() {
            //arrange
            var entregador = Util.gerarEntregador();
            entregador.desativar();
            Mockito.when(entregadorRepository.save(Mockito.any(Entregador.class))).thenReturn(entregador);

            //act
            var entregadorSalvo = entregadorRepository.save(entregador);

            //assert
            verify(entregadorRepository, times(1)).save(Mockito.any(Entregador.class));
            assertThat(entregadorSalvo).isInstanceOf(Entregador.class).isNotNull().isEqualTo(entregador);

            assertThat(entregadorSalvo).extracting(Entregador::getId).isEqualTo(entregador.getId());

            assertThat(entregadorSalvo).extracting(Entregador::getNome).isEqualTo(entregadorSalvo.getNome());

            assertThat(entregadorSalvo).extracting(Entregador::getStatusEntregador).isEqualTo(entregadorSalvo.getStatusEntregador()).isEqualTo(StatusEntregador.DESATIVADO);
            ;
        }

    }


    @Nested
    @DisplayName("Deve testar a consulta de entregadores.")
    class ConsultarEntregadoresTeste {

        @Test
        void deveConsultarUmEntregador() {
            //arrange
            var entregador = Util.gerarEntregador();
            entregador.setId(1L);

            Mockito.when(entregadorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(entregador));

            //act
            Optional<Entregador> entregadorSalvo = entregadorRepository.findById(1L);

            //assert
            verify(entregadorRepository, times(1)).findById(Mockito.anyLong());
            assertThat(entregadorSalvo).isPresent()
                    //Verifica se o valor contido no Optional é o mesmo objeto (não apenas equivalente) que o objeto restaurante.
                    .containsSame(entregador);

            entregadorSalvo.ifPresent(entregadorarmazenado -> {
                assertThat(entregadorarmazenado.getId()).isEqualTo(1L);
                assertThat(entregadorarmazenado.getNome()).isEqualTo(entregador.getNome());
            });
        }

        @Test
        void deveConsultarMaisDeUmEntregador() {

            //arange
            var entregador1 = Util.gerarEntregador();
            var entregador2 = Util.gerarEntregador();
            var listaDeEntregadores = Arrays.asList(entregador1, entregador2);

            Mockito.when(entregadorRepository.findAll()).thenReturn(listaDeEntregadores);

            //act
            var resultado = entregadorRepository.findAll();

            verify(entregadorRepository, times(1)).findAll();
            assertThat(resultado).hasSize(2).contains(entregador1, entregador2);
        }

    }
}

