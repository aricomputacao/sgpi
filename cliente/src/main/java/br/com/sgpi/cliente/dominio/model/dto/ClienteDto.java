package br.com.sgpi.cliente.dominio.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteDto(
        Integer id,
        @NotEmpty
        String nome,
        @Email
        String email,
        String telefone,
        @CPF
        String cpf,
        @NotEmpty
        String estado,
        @NotEmpty
        String cidade,
        @NotEmpty
        String endereco,
        String cep
) {
}
