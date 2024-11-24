package br.com.sgpi.logistica.dominio.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {

    private Long id;
    @NotNull
    private Integer quantidade;
    private String descricao;
}
