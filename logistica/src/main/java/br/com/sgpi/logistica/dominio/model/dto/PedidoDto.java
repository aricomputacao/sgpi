package br.com.sgpi.logistica.dominio.model.dto;

import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.util.CampoNaoPermitido;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {

    private Long id;

    @CampoNaoPermitido
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataEntrada;
    private LocalDateTime previsaoEntrega;
    private LocalDateTime dataEntrega;
    @NonNull
    private StatusPedido status;
    @NotEmpty
    private String enderecoDestino;
    private Entregador entregador;
    @NotNull
    private List<ItemDto> itens = new ArrayList<>();

}
