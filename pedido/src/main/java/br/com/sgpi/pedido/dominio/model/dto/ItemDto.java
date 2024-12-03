package br.com.sgpi.pedido.dominio.model.dto;

import br.com.sgpi.pedido.dominio.util.validators.CampoNaoPermitido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    @NotNull
    @Positive
    private Long idProduto;

    @NotNull
    @Positive
    private Integer quantidade;

    @CampoNaoPermitido
    private BigDecimal preco;

    @CampoNaoPermitido
    private String descricao;

}
