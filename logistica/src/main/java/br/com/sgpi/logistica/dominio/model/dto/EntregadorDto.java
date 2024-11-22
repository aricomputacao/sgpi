package br.com.sgpi.logistica.dominio.model.dto;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.Veiculo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EntregadorDto(
        Long id,
        @NotEmpty
        String nome,
        @NotNull
        Veiculo veiculo,
        @NotNull
        StatusEntregador statusEntregador,
        @NotNull
        BigDecimal latitude,
        @NotNull
        BigDecimal longitude
) {


}
