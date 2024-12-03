package br.com.sgpi.pedido.dominio.util.schedulers;

import br.com.sgpi.pedido.dominio.enumeration.StatusProduto;
import br.com.sgpi.pedido.dominio.model.dto.ClienteDto;
import br.com.sgpi.pedido.dominio.model.dto.ProdutoDto;
import br.com.sgpi.pedido.dominio.model.entity.Item;
import br.com.sgpi.pedido.dominio.model.entity.Pedido;
import br.com.sgpi.pedido.dominio.repository.ItemRepository;
import br.com.sgpi.pedido.dominio.repository.PedidoRepository;
import br.com.sgpi.pedido.dominio.service.ClienteService;
import br.com.sgpi.pedido.dominio.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class TarefaAgendada {

    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    // Executa a cada 10 segundos
    @Scheduled(fixedRate = 10000)
    public void processarPedidosPendentes() {

        List<Pedido> pedidos = pedidoRepository.findAllByEstoqueValidadoFalseOrClienteIntegradoFalse();

        pedidos.forEach(pedido -> {
            boolean baixarEstoque = false;
            if (pedido.isNotEstoqueValidado()) {
                pedido.getItens().stream()
                        .filter(item -> StatusProduto.NAO_VALIDADO.equals(item.getStatusProduto()))
                        .forEach(this::processarItem);
                baixarEstoque = pedido.getItens().stream()
                        .noneMatch(item -> StatusProduto.NAO_VALIDADO.equals(item.getStatusProduto()));
            }
            boolean comunicarCliente = false;
            if (pedido.isNotClienteIntegrado()) {
                ClienteDto clienteDto = clienteService.consultarClientePor(pedido.getCpfCliente());
                if (clienteDto.isClienteIntegrado()) {
                    pedido.preencherDadosCliente(clienteDto);
                    pedido.setClienteIntegrado(true);
                    comunicarCliente = true;
                    pedidoRepository.saveAndFlush(pedido);
                }
            }

            if (baixarEstoque) {
                pedido.getItens().forEach(item -> {
                    ProdutoDto produtoDto = produtoService.baixarEstoque(item.getIdProduto(), item.getQuantidade());
                    log.info("****** Baixando estoque de {} quantidade {}", item.getDescricao(), item.getQuantidade());
                    if (produtoDto.isNotStatusValido()) {
                        item.setStatusProduto(StatusProduto.NAO_VALIDADO);
                        itemRepository.saveAndFlush(item);
                        pedido.setEstoqueValidado(false);
                        pedidoRepository.saveAndFlush(pedido);
                        return;
                    }
                    pedido.setEstoqueValidado(true);
                    pedidoRepository.saveAndFlush(pedido);
                });
            }
            if (comunicarCliente) {
                //TODO: COMUNICAR CLIENTE
            }
        });


    }

    private void processarItem(Item item) {
        ProdutoDto produtoDto = produtoService.buscarProduto(item.getIdProduto());
        if (produtoDto.isStatusValido()) {
            item.preencherDadosProduto(produtoDto);
            item.setStatusProduto(produtoDto.statusProduto());
            itemRepository.save(item);
        }
    }
}
