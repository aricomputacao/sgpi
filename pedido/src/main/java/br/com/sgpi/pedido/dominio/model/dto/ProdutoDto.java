package br.com.sgpi.pedido.dominio.model.dto;


import br.com.sgpi.pedido.dominio.enumeration.StatusProduto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder

public record ProdutoDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        int quantidadeEstoque,
        StatusProduto statusProduto
) {

    public ProdutoDto criarProdutoComStatusValidado()  {
        return ProdutoDto.builder()
                .id(this.id())
                .nome(this.nome())
                .descricao(this.descricao())
                .preco(this.preco())
                .quantidadeEstoque(this.quantidadeEstoque())
                .statusProduto(StatusProduto.VALIDADO)
                .build();
    }

    public boolean isStatusValido() {
        return StatusProduto.VALIDADO.equals(statusProduto);
    }
    public boolean isNotStatusValido() {
        return !isStatusValido();
    }
}

