package br.com.sgpi.pedido.dominio.service;

import br.com.sgpi.pedido.apllication.http.ProdutoClient;
import br.com.sgpi.pedido.dominio.enumeration.StatusProduto;
import br.com.sgpi.pedido.dominio.model.dto.ProdutoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProdutoService {

    private ProdutoClient produtoClient;

    @CircuitBreaker(name = "buscarProduto", fallbackMethod = "fallbackBuscarProduto")
    public ProdutoDto buscarProduto(Long idProduto) {
        ProdutoDto produtoDto = produtoClient.buscarProduto(idProduto);
        produtoDto = produtoDto.criarProdutoComStatusValidado();
        return produtoDto;
    }

    public ProdutoDto fallbackBuscarProduto(Long idProduto, Throwable ex) {
//        pedido.setStatus(StatusPedido.PENDENTE_CONFIRMACAO_ESTOQUE);
        log.warn("Executando fallbackBuscarProduto para produto {}", idProduto);
        return ProdutoDto.builder()
                .id(idProduto)
                .statusProduto(StatusProduto.NAO_VALIDADO)
                .build();
    }

    @CircuitBreaker(name = "baixarEstoque", fallbackMethod = "fallbackBaixarEstoque")
    public ProdutoDto baixarEstoque(Long idProduto, Integer quantidade) {
        ProdutoDto produtoDto = produtoClient.baixarEstoque(idProduto, quantidade);
        produtoDto = produtoDto.criarProdutoComStatusValidado();
        return produtoDto;
    }

    public ProdutoDto fallbackBaixarEstoque(Long idProduto, Integer quantidade, Throwable ex) {
        log.warn("Executando fallbackBaixarEstoque para produto {}", idProduto);
        return ProdutoDto.builder()
                .id(idProduto)
                .statusProduto(StatusProduto.NAO_VALIDADO)
                .build();
    }


}
