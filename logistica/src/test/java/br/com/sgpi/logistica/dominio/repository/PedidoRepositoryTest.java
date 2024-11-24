package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import br.com.sgpi.logistica.util.Util;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PedidoRepositoryTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Nested
    class ManterPedido {

        @Test
        void deveRegistrarPedido() {
            //arrange
            var pedido = Util.gerarPedido();
            Mockito.when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedido);

            //act
            var pedidoSalvo = pedidoRepository.save(pedido);

            //assert
            verify(pedidoRepository, times(1)).save(Mockito.any(Pedido.class));
            assertThat(pedidoSalvo)
                    .isInstanceOf(Pedido.class)
                    .isNotNull()
                    .isEqualTo(pedido);
            assertThat(pedidoSalvo).extracting(Pedido::getId).isEqualTo(pedido.getId());
            assertThat(pedidoSalvo).extracting(Pedido::getEnderecoDestino).isEqualTo(pedido.getEnderecoDestino());
        }
    }
    @Nested
    class ConsultarPedido {

        @Test
        void deveConsultarUmPedido() {
            //arrange
            Long pedidoId = 1L;
            var pedido = Util.gerarPedido();
            pedido.setId(pedidoId);

            Mockito.when(pedidoRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(pedido));

            //act
            var pedidoSalvo = pedidoRepository.findById(pedidoId);

            //assert
            verify(pedidoRepository, times(1)).findById(pedidoId);
            assertThat(pedidoSalvo).isPresent().contains(pedido);
            pedidoSalvo.ifPresent(pedidoArmazenado -> {
                assertThat(pedidoArmazenado.getId()).isEqualTo(pedidoId);
                assertThat(pedidoArmazenado.getEnderecoDestino()).isEqualTo(pedido.getEnderecoDestino());
            });
        }

        @Test
        void deveConsultarPedido() {
            //arrange
            var pedido1 = Util.gerarPedido();
            var pedido2 = Util.gerarPedido();
            List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);
            Mockito.when(pedidoRepository.findAll()).thenReturn(pedidos);

            //act
            var listaDePedidos = pedidoRepository.findAll();

            //assert
            verify(pedidoRepository, times(1)).findAll();
            assertThat(listaDePedidos).hasSize(2).containsExactlyInAnyOrder(pedido1, pedido2);

        }
    }
}