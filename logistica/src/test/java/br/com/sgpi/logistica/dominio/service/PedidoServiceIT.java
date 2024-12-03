package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import br.com.sgpi.logistica.dominio.model.mapper.PedidoMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.dominio.repository.ItemPedidoRepository;
import br.com.sgpi.logistica.dominio.repository.PedidoRepository;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import br.com.sgpi.logistica.util.Util;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PedidoServiceIT {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private EntregadorService entregadorService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ClienteClient clienteClient;

    @Test
    @Order(1)
    void deveCriarERecuperarPedido() {
        // Arrange: Cria dados para o teste
        Entregador entregador = registrarEntregador();

        PedidoDto pedidoDto = Util.gerarPedidoDto();
        pedidoDto.setEntregador(entregador);

        // Act: Cria o pedido
        PedidoDto pedidoCriado = pedidoService.criarPedido(pedidoDto);

        // Assert: Verifica se o pedido foi salvo corretamente
        assertNotNull(pedidoCriado.getId());
        Pedido pedidoSalvo = pedidoRepository.findById(pedidoCriado.getId()).orElseThrow();
        assertEquals(pedidoCriado.getId(), pedidoSalvo.getId());
        assertEquals(StatusPedido.PRONTO, pedidoSalvo.getStatus());
        assertEquals(2, pedidoSalvo.getItens().size());
    }

    @Test
    void deveAtualizarStatusDePedido() {
        // Arrange: Cria um pedido no banco de dados
        Pedido pedido = registrarPedido();

        // Act: Atualiza o status do pedido
        PedidoDto pedidoAtualizado = pedidoService.atualizaStatus(pedido.getId(), StatusPedido.NAO_AUTORIZADO);

        // Assert: Verifica se o status foi atualizado corretamente
        assertEquals(StatusPedido.NAO_AUTORIZADO, pedidoAtualizado.getStatus());
    }

    @Test
    void deveAlocarEntregadorParaPedido() {
        // Arrange: Cria um pedido e um entregador no banco de dados
        Pedido pedido = registrarPedido();

        Entregador entregador = registrarEntregador();

        // Act: Aloca o entregador ao pedido
        PedidoDto pedidoAlocado = pedidoService.alocarPedido(pedido.getId(), entregador.getId());

        // Assert: Verifica se o entregador foi alocado corretamente
        assertNotNull(pedidoAlocado.getEntregador());
        assertEquals(entregador.getId(), pedidoAlocado.getEntregador().getId());
    }

    @Test
    void deveLancarExcecaoAoAlocarEntregadorInativo() {
        // Arrange: Cria um pedido e um entregador inativo no banco de dados
        Pedido pedido = registrarPedido();

        Entregador entregador = registrarEntregador();
        entregador.setStatusEntregador(StatusEntregador.DESATIVADO);
        entregadorRepository.save(entregador);

        // Act & Assert: Tenta alocar o entregador e verifica se lança exceção
        assertThrows(RegraDeNegocioException.class,
                () -> pedidoService.alocarPedido(pedido.getId(), entregador.getId()));
    }

    @Test
    void deveLancarExcecaoSemEntregadorVinculado() {
        // Arrange: Cria um pedido no banco de dados
        Pedido pedido = registrarPedido();

        // Act & Assert: Tenta entregar e verifica sem tem entregador vinculado
        assertThrows(RegraDeNegocioException.class,
                () -> pedidoService.entregarPedido(pedido.getId()));
    }

    @Test
    void deveEntregarPedidoComSucesso() {
        // Arrange

        Pedido pedido = Util.gerarPedido();
        Entregador entregador = registrarEntregador();
        pedido.setEntregador(entregador);
        pedido =  pedidoRepository.save(pedido);

        // Act
        PedidoDto pedidoDto = pedidoService.entregarPedido(pedido.getId());

        // Assert
        assertNotNull(pedidoDto);
        assertEquals(StatusPedido.ENTREGUE, pedidoDto.getStatus());
        assertNotNull(pedidoDto.getDataEntrega());
    }


    @Test
    void deveEntregarPedido() {
        // Arrange: Cria um pedido no banco de dados
        Pedido pedido = registrarPedido();
        Entregador entregador = registrarEntregador();
        pedido.setEntregador(entregador);

        // Act: Marca o pedido como entregue
        pedidoService.entregarPedido(pedido.getId());

        // Assert: Verifica se o pedido foi entregue
        Pedido pedidoEntregue = pedidoRepository.findById(pedido.getId()).orElseThrow();
        assertEquals(StatusPedido.ENTREGUE, pedidoEntregue.getStatus());
        assertNotNull(pedidoEntregue.getDataEntrega());
    }

    private Entregador registrarEntregador() {
        Entregador entregador = Util.gerarEntregador();
        return entregadorRepository.save(entregador);
    }

    private Pedido registrarPedido() {
        Pedido pedido = Util.gerarPedido();
        pedido.setStatus(StatusPedido.PRONTO);
        return pedidoRepository.save(pedido);
    }

    private Pedido registrarPedidoComEntregador() {
        Pedido pedido = Util.gerarPedido();
        pedido.setStatus(StatusPedido.PRONTO);
        Entregador entregador = registrarEntregador();
        pedido.setEntregador(entregador);
        return pedidoRepository.save(pedido);
    }
}
