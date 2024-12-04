package br.com.sgpi.logistica.dominio.model.entity;

import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.util.validators.Criacao;
import br.com.sgpi.logistica.dominio.util.validators.Present;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido", schema = "logistica")
@SequenceGenerator(name = "seq_pedido_id", sequenceName = "seq_pedido_id", allocationSize = 1, schema = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long id;

    @Present(groups = Criacao.class)
    @NotNull
    @Column(name = "ped_data_entrada", nullable = false, updatable = false)
    private LocalDateTime dataEntrada;

    @FutureOrPresent
    @Column(name = "ped_previsao_entrega")
    private LocalDateTime previsaoEntrega;

    @Column(name = "ped_data_entrega")
    private LocalDateTime dataEntrega;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ped_status", nullable = false)
    private StatusPedido status;

    @NotEmpty
    @CPF
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

    @ManyToOne
    @JoinColumn(name = "ent_id", referencedColumnName = "ent_id",
            foreignKey = @ForeignKey(name = "fk_entregador"))
    private Entregador entregador;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "pedido_item",schema = "logistica",// Nome da tabela de junção
            uniqueConstraints = @UniqueConstraint(name = "uk_item", columnNames = {"ite_id"}),
            joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "ped_id",
                    foreignKey = @ForeignKey(name = "fk_pedido")), // FK para Pedido
            inverseJoinColumns = @JoinColumn(name = "ite_id", referencedColumnName = "ite_id",
                    foreignKey = @ForeignKey(name = "fk_item") // FK para ItemDoPedido
            ))
    private List<Item> itens = new ArrayList<>();

    public boolean isEntregue(){
        return StatusPedido.ENTREGUE.equals(status);
    }

    public boolean isPedidoSemEntregadorVinculado(){
        return this.entregador == null || this.entregador.getId() == null;
    }
}
