package br.com.sgpi.pedido.dominio.service;

import br.com.sgpi.pedido.dominio.enumeration.StatusPedido;
import br.com.sgpi.pedido.dominio.enumeration.StatusProduto;
import br.com.sgpi.pedido.dominio.model.dto.ClienteDto;
import br.com.sgpi.pedido.dominio.model.dto.PedidoRequestDto;
import br.com.sgpi.pedido.dominio.model.dto.PedidoResponseDto;
import br.com.sgpi.pedido.dominio.model.dto.ProdutoDto;
import br.com.sgpi.pedido.dominio.model.entity.Pedido;
import br.com.sgpi.pedido.dominio.model.mapper.PedidoMapper;
import br.com.sgpi.pedido.dominio.repository.ItemRepository;
import br.com.sgpi.pedido.dominio.repository.PedidoRepository;
import br.com.sgpi.pedido.infra.config.AmqpConfiguration;
import br.com.sgpi.pedido.infra.exception.RegraDeNegocioException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Slf4j
@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemRepository itemRepository;
    private final PedidoMapper pedidoMapper;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;
    private final RabbitTemplate rabbitTemplate;


    public Page<PedidoResponseDto> obterTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(p -> pedidoMapper.entityToDtoResponse(p));
    }

    public PedidoResponseDto obterPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return pedidoMapper.entityToDtoResponse(pedido);
    }

    public PedidoRequestDto atualizaStatus(Long id, StatusPedido dto) {

        Pedido pedido = repository.porIdComItens(id);

        if (pedido == null) {
            throw new EntityNotFoundException();
        }

        pedido.setStatus(dto);
        repository.atualizaStatus(dto, pedido);
        return pedidoMapper.entityToDto(pedido);
    }

    public void aprovaPagamentoPedido(Long id) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }
        pedido.setStatus(StatusPedido.PAGO);
        log.info("****** Pedido: {} confirmando com sucesso.", pedido.getId());
        repository.atualizaStatus(StatusPedido.PAGO, pedido);
    }

    @Transactional
    public PedidoResponseDto criarPedido(PedidoRequestDto dto) {
        log.info("Criando pedido: {}", dto.toString());
        Pedido pedido = pedidoMapper.dtoToEntity(dto);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setEstoqueValidado(true);
        pedido.getItens().forEach(item -> {
            log.info("***Validando Item: {}", item.getIdProduto());
            ProdutoDto produtoDto = produtoService.buscarProduto(item.getIdProduto());
            if (produtoDto == null || produtoDto.id() == null) {
                throw new RegraDeNegocioException("Produto com ID: " + item.getIdProduto() + " não encontrado no estoque.");
            }
            if (produtoDto.isStatusValido() && produtoDto.quantidadeEstoque() < item.getQuantidade()) {
                throw new RegraDeNegocioException("Produto " + produtoDto.nome() + " sem estoque.");
            }
            item.setStatusProduto(produtoDto.statusProduto());
            if (produtoDto.isStatusValido()) {
                item.preencherDadosProduto(produtoDto);
            } else {
                item.setDescricao("Não Validado");
                item.setPreco(BigDecimal.ZERO);
                pedido.setEstoqueValidado(false);
            }
        });
        itemRepository.saveAll(pedido.getItens());
        ClienteDto clienteDto = clienteService.consultarClientePor(pedido.getCpfCliente());
        pedido.preencherDadosCliente(clienteDto);
        repository.save(pedido);
        if (pedido.isEstoqueValidado()) {
            pedido.getItens().forEach(item -> {
                ProdutoDto produtoDto = produtoService.baixarEstoque(item.getIdProduto(), item.getQuantidade());
                log.info("****** Baixando estoque de {} quantidade {}", item.getDescricao(), item.getQuantidade());
                if (produtoDto.isNotStatusValido()) {
                    item.setStatusProduto(StatusProduto.NAO_VALIDADO);
                    pedido.setEstoqueValidado(false);
                    itemRepository.saveAndFlush(item);
                    repository.saveAndFlush(pedido);
                    return;
                }
            });
        }
        log.info("******Pedido criado: {}", pedido);
        if (pedido.isClienteIntegrado() && pedido.isEstoqueValidado()) {
            log.info("******Enviado pedido para filas. ");
            rabbitTemplate.convertAndSend(AmqpConfiguration.PEDIDO_EXCHANGE, "", pedidoMapper.entityToDtoResponse(pedido));
        }
        return pedidoMapper.entityToDtoResponse(pedido);
    }


}
