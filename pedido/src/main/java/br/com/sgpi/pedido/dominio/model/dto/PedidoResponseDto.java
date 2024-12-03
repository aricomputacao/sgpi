package br.com.sgpi.pedido.dominio.model.dto;

import br.com.sgpi.pedido.dominio.enumeration.StatusPedido;
import br.com.sgpi.pedido.dominio.util.validators.CampoNaoPermitido;
import br.com.sgpi.pedido.dominio.util.validators.Criacao;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private Long id;

    private LocalDateTime dataHora;

    private StatusPedido status;

    @NotEmpty
    private List<ItemDto> itens = new ArrayList<>();

    @NotEmpty
    @CPF
    private String cpfCliente;

    private String nomeCliente;

    private String cidadeCliente;

    @Email
    private String emailCliente;

    private String enderecoCliente;

}
