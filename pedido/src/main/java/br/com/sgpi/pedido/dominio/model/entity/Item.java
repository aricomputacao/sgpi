package br.com.sgpi.pedido.dominio.model.entity;

import br.com.sgpi.pedido.dominio.enumeration.StatusProduto;
import br.com.sgpi.pedido.dominio.model.dto.ProdutoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item", schema = "pedido")
@SequenceGenerator(name = "seq_item_id", sequenceName = "seq_item_id", allocationSize = 1, schema = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "ite_id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ite_id", updatable = false)
    private Long id;

    @NotNull
    @PositiveOrZero
    @Column(name = "ite_quantidade", nullable = false)
    private Integer quantidade;

    @NotEmpty
    @Column(name = "ite_descricao", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "ite_produto", updatable = false)
    private Long idProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "ite_status_produto", nullable = false)
    private StatusProduto statusProduto;

    @NotNull
    @PositiveOrZero
    @Column(name = "ite_preco", nullable = false, updatable = false)
    private  BigDecimal preco;

    public void preencherDadosProduto(ProdutoDto produto) {
        this.descricao = produto.nome();
        this.preco = produto.preco();
    }

    public boolean isNotValidado(){
        return StatusProduto.NAO_VALIDADO.equals(statusProduto);
    }

}
