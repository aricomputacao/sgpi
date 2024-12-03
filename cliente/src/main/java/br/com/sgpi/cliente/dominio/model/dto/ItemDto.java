package br.com.sgpi.cliente.dominio.model.dto;

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

    private Long idProduto;

    private Integer quantidade;

    private BigDecimal preco;

    private String descricao;

}
