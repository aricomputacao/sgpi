package br.com.sgpi.pedido.dominio.model.entity;

import br.com.sgpi.pedido.dominio.enumeration.StatusPedido;
import br.com.sgpi.pedido.dominio.model.dto.ClienteDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos", schema = "pedido")
@SequenceGenerator(name = "seq_pedido_id", sequenceName = "seq_pedido_id", allocationSize = 1, schema = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "ped_id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @NotNull
    @Column(name = "ped_data", nullable = false, updatable = false)
    private LocalDateTime dataHora;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "pes_status", nullable = false)
    private StatusPedido status;

    @NotEmpty
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "pedido_item", schema = "pedido", // Nome da tabela de junção
            uniqueConstraints = @UniqueConstraint(name = "uk_item_pedido", columnNames = {"ite_id", "ped_id"}),
            joinColumns = @JoinColumn(name = "ped_id", referencedColumnName = "ped_id",
                    foreignKey = @ForeignKey(name = "fk_pedido")), // FK para Pedido
            inverseJoinColumns = @JoinColumn(name = "ite_id", referencedColumnName = "ite_id",
                    foreignKey = @ForeignKey(name = "ite_id") // FK para ItemDoPedido
            ))
    private List<Item> itens = new ArrayList<>();

    @NotBlank
    @Column(name = "ped_cpf_cliente", nullable = false, updatable = false)
    private String cpfCliente;

    @NotBlank
    @Column(name = "ped_nome_cliente", nullable = false, updatable = false)
    private String nomeCliente;

    @NotBlank
    @Column(name = "ped_cidade_cliente", nullable = false, updatable = false)
    private String cidadeCliente;

    @NotBlank
    @Column(name = "ped_endereco_cliente", nullable = false, updatable = false)
    private String enderecoCliente;

    @NotBlank
    @Email
    @Column(name = "ped_email_cliente", nullable = false, updatable = false)
    private String emailCliente;

    @NotNull
    @Column(name = "ped_cliente_integrado", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean clienteIntegrado;

    @NotNull
    @Column(name = "ped_estoque_validado", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean estoqueValidado;

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now();
    }

    public void preencherDadosCliente(ClienteDto clienteDto) {
        this.cpfCliente = clienteDto.getCpf();
        this.nomeCliente = clienteDto.isClienteIntegrado() ? clienteDto.getNome() : "INDISPONIVEL";
        this.cidadeCliente = clienteDto.isClienteIntegrado() ? clienteDto.getCidade() : "INDISPONIVEL";
        this.enderecoCliente = clienteDto.isClienteIntegrado() ? clienteDto.getEndereco()  : "INDISPONIVEL";
        this.emailCliente = clienteDto.isClienteIntegrado() ? clienteDto.getEmail()  : "INDISPONIVEL@ind.com";
        this.clienteIntegrado = clienteDto.isClienteIntegrado();
    }

    public boolean isNotEstoqueValidado() {
        return !estoqueValidado;
    }

    public boolean isNotClienteIntegrado() {
        return !clienteIntegrado;
    }
}
