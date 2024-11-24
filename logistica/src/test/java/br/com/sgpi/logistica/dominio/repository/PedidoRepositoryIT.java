package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.model.entity.Pedido;
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
        "/data_pedido.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class PedidoRepositoryIT {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Test
    @Order(1)
    void devePermitirCriarTabela() {
        var totalRegistros = pedidoRepository.count();
        assertThat(totalRegistros).isNotNegative();
    }

    @Nested
    @Order(1)
    class ManterPedido {

        @Test
        @Order(1)
        void devePermitirRegistrarPedido() {
            //arrange
            var pedido = Util.gerarPedido();

            //act
            itemPedidoRepository.saveAll(pedido.getItens());
            var pedidoSalvo = pedidoRepository.save(pedido);

            //assert
            assertThat(pedidoSalvo)
                    .isInstanceOf(Pedido.class)
                    .isNotNull();
            assertThat(pedidoSalvo)
                    .extracting(Pedido::getId)
                    .isEqualTo(pedido.getId());
            assertThat(pedidoSalvo)
                    .extracting(Pedido::getDataEntrada)
                    .isEqualTo(pedido.getDataEntrada());
        }
    }
    @Nested
    class ConsultarPedido {

        @Test
        void deveConsultarUmPedido() {
            //arrange
            var pedido = registraPedido();
            Long pedidoId = pedido.getId();

            //act
            Optional<Pedido> pedidoConsultado = pedidoRepository.findById(pedidoId);;

            //assert
            assertThat(pedidoConsultado)
                    .isPresent()
                    //Verifica se o valor contido no Optional é o mesmo objeto (não apenas equivalente) que o objeto restaurante.
                    .containsSame(pedido);
            pedidoConsultado.ifPresent(pedidoArmazenado -> {
                assertThat(pedidoArmazenado.getId()).isEqualTo(pedidoId);
                assertThat(pedidoArmazenado.getDataEntrada()).isEqualTo(pedido.getDataEntrada());
            });
        }

        @Test
        void deveConsultaredidos() {

            //act+assert
            assertThatCode(() -> {
               var resultado = pedidoRepository.findAll();
               assertThat(resultado).isInstanceOf(List.class);
            }).doesNotThrowAnyException();
        }
    }


    private Pedido registraPedido() {
        Pedido pedido = Util.gerarPedido();
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedidoRepository.save(pedido);
    }
}
