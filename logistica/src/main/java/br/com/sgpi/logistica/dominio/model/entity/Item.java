package br.com.sgpi.logistica.dominio.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "item", schema = "logistica")
@SequenceGenerator(name = "seq_item_id", sequenceName = "seq_item_id", allocationSize = 1, schema = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "ite_id")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ite_id")
    private Long id;

    @NotNull
    @Positive
    @Column(name = "ite_quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "ite_descricao")
    private String descricao;



}
