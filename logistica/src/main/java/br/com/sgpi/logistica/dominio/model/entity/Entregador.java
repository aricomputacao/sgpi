package br.com.sgpi.logistica.dominio.model.entity;

import br.com.sgpi.logistica.dominio.enumeration.StatusEntregador;
import br.com.sgpi.logistica.dominio.enumeration.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "entregador", schema = "logistica")
@SequenceGenerator(name = "seq_entregador_id", sequenceName = "seq_entregador_id", allocationSize = 1, schema = "logistica")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ent_id")
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Column(name = "ent_nome", nullable = false)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ent_veiculo", nullable = false)
    private Veiculo veiculo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ent_status", nullable = false)
    private StatusEntregador statusEntregador;

    @NotNull
    @Column(name = "ent_latitude",precision = 10, scale = 8, nullable = false)
    private BigDecimal latitude;

    @NotNull
    @Column(name = "ent_longitude", precision = 11, scale = 8, nullable = false)
    private BigDecimal longitude;

    public void desativar() {
        this.statusEntregador = StatusEntregador.DESATIVADO;
    }

    public boolean isAtivo() {
        return !StatusEntregador.DESATIVADO.equals(this.statusEntregador);
    }
}
