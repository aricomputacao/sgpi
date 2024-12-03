package br.com.sgpi.produto.dominio.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto", schema = "produto")
@SequenceGenerator(name = "seq_produto_id", sequenceName = "seq_produto_id", allocationSize = 1, schema = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id")
    private Long id;

    @NotEmpty
    @Column(name = "prd_nome",  unique = true, nullable = false)
    private String nome;

    @Column(name = "prd_descricao")
    private String descricao;

    @NotNull
    @PositiveOrZero
    @Column(name = "prd_preco", nullable = false)
    private BigDecimal preco;

    @NotNull
    @PositiveOrZero
    @Column(name = "prd_quantidade_estoque", nullable = false)
    private int quantidadeEstoque;

    public void baixarEstoque(@NotNull Integer quantidade) {
        if (this.quantidadeEstoque < quantidade) {
            throw new IllegalArgumentException("Estoque negativo");
        }
        this.quantidadeEstoque -= quantidade;
    }
}
