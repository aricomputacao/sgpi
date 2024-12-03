package br.com.sgpi.pedido.dominio.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    private Integer id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    private String telefone;

    @CPF
    private String cpf;

    @NotBlank
    private String estado;

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    private String cep;

    private boolean clienteIntegrado;
}
