package br.com.sgpi.cliente.dominio.model.dto;

import br.com.sgpi.cliente.dominio.enumeration.StatusPedido;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames = true)
public class PedidoDto {

    private Long id;

    private LocalDateTime dataHora;

    private StatusPedido status;

    @NotEmpty
    private List<ItemDto> itens = new ArrayList<>();

    private String cpfCliente;

    private String nomeCliente;

    private String cidadeCliente;

    private String emailCliente;

    private String enderecoCliente;

}
