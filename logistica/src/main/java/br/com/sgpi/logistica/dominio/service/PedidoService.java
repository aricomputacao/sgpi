package br.com.sgpi.logistica.dominio.service;

import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.entity.Item;
import br.com.sgpi.logistica.dominio.model.entity.Pedido;
import br.com.sgpi.logistica.dominio.model.mapper.PedidoMapper;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.dominio.repository.ItemPedidoRepository;
import br.com.sgpi.logistica.dominio.repository.PedidoRepository;
import br.com.sgpi.logistica.infra.exception.RegraDeNegocioException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final EntregadorRepository entregadorRepository;
    private final PedidoMapper pedidoMapper;

    public List<PedidoDto> obterTodos() {
        return repository.findAll().stream()
                .map(p -> pedidoMapper.entityToDto(p)).collect(Collectors.toList());
    }

    public PedidoDto obterPorId(Long id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return pedidoMapper.entityToDto(pedido);
    }

    @Transactional
    public PedidoDto criarPedido(PedidoDto dto) {
        Pedido pedido = pedidoMapper.dtoToEntity(dto);
        pedido.setDataEntrada(LocalDateTime.now());
        pedido.setStatus(StatusPedido.PRONTO);
        itemPedidoRepository.saveAll(pedido.getItens());
        pedido.setItens(carregarItensPersistidos(pedido.getItens()));
        pedido.setEntregador(dto.getEntregador());
        repository.save(pedido);
        log.info("****** Pedido: {} salvo com sucesso.", pedido.getId());
        return pedidoMapper.entityToDto(pedido);
    }

    public PedidoDto atualizaStatus(Long id, StatusPedido dto) {

        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }
        pedido.setStatus(dto);
        repository.atualizaStatus(dto, pedido);
        return pedidoMapper.entityToDto(pedido);
    }

    public PedidoDto alocarPedido(Long idPedido, Long idEntregador) {
        Optional<Pedido> pedido = repository.findById(idPedido);
        Optional<Entregador> entregador = entregadorRepository.findById(idEntregador);

        if (pedido.isEmpty()) {
            throw new RegraDeNegocioException("Pedido com ID "+ idPedido+" não encontrado.");
        }
        if (entregador.isEmpty() || !entregador.get().isAtivo()) {
            throw new RegraDeNegocioException("Entregador com ID "+ idEntregador+" não disponível.");
        }
        pedido.get().setEntregador(entregador.get());
        repository.vincularEntregador(pedido.get(), entregador.get());
        return pedidoMapper.entityToDto(pedido.get());
    }

    public void entregarPedido(Long id) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new RegraDeNegocioException("Pedido com id: "+id+" não encontrado.");
        }
        if (pedido.isPedidoSemEntregadorVinculado()){
            throw new RegraDeNegocioException("Pedido com id: "+id+" sem entrgador vinvulado.");
        }
        if (pedido.isEntregue()) {
            throw new RegraDeNegocioException("Pedido com id "+id+" já consta como entregue.");
        }
        pedido.setDataEntrega(LocalDateTime.now());
        log.info("****** Pedido: {} entregue com sucesso.", pedido.getId());
        repository.atualizaStatus(StatusPedido.ENTREGUE, pedido);
    }

    private List<Item> carregarItensPersistidos(List<Item> itens) {
        List<Item> itensPersistidos = new ArrayList<>();
        for (Item item : itens) {
            if (item.getId() != null) {
                Item itemPersistido = itemPedidoRepository.findById(item.getId())
                        .orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));
                itensPersistidos.add(itemPersistido);
            } else {
                itensPersistidos.add(item);
            }
        }
        return itensPersistidos;
    }
}
