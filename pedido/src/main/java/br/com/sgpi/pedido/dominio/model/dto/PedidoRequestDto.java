package br.com.sgpi.pedido.dominio.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {

    @Valid
    @NotEmpty
    private List<ItemDto> itens = new ArrayList<>();

    @NotEmpty
    @CPF
    private String cpfCliente;

}
