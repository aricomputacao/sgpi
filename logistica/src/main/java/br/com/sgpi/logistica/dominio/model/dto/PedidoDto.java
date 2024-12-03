package br.com.sgpi.logistica.dominio.model.dto;

import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.util.validators.CampoNaoPermitido;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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
    private LocalDateTime dataEntrada;
    private LocalDateTime previsaoEntrega;
    private LocalDateTime dataEntrega;
    @NotNull
    private StatusPedido status;
    @NotEmpty
    private String enderecoDestino;
    @NotEmpty
    @CPF
    private String cpfCliente;
    private Entregador entregador;
    @NotNull
    private List<ItemDto> itens = new ArrayList<>();
    private String nomeCliente;

    private String cidadeCliente;

    @Email
    private String emailCliente;

    private String enderecoCliente;
}
