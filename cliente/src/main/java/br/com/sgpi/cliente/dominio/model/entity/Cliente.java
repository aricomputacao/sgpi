package br.com.sgpi.cliente.dominio.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "cliente", schema = "logistica")
@SequenceGenerator(name = "seq_cliente_id", sequenceName = "seq_cliente_id", allocationSize = 1, schema = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "cli_id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Integer id;

    @NotEmpty
    @Column(name = "cli_nome", nullable = false, updatable = false)
    private String nome;

    @Email
    @NotEmpty
    @Column(name = "cli_email", nullable = false)
    private String email;

    @Column(name = "cli_telefone")
    private String telefone;

    @CPF
    @NotEmpty
    @Column(name = "cli_cpf", nullable = false, updatable = false)
    private String cpf;

    @NotEmpty
    @Column(name = "cli_estado", nullable = false)
    private String estado;

    @NotEmpty
    @Column(name = "cli_cidade", nullable = false)
    private String cidade;

    @NotEmpty
    @Column(name = "cli_endereco", nullable = false)
    private String endereco;

    @Column(name = "cli_cep")
    private String cep;

}
