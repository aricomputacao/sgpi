package br.com.sgpi.produto.dominio.model.dto;
import br.com.sgpi.produto.dominio.model.entity.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public record ProdutoRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @NotBlank(message = "A descrição do produto é obrigatória")
        String descricao,

        @NotNull(message = "O preço do produto é obrigatório")
        @Positive(message = "O preço do produto deve ser um valor positivo")
        BigDecimal preco,

        @NotNull(message = "A quantidade em estoque é obrigatória")
        int quantidadeEstoque
) {
    public Produto toEntity() {
        return new Produto(null, nome, descricao, preco, quantidadeEstoque);
    }
}
