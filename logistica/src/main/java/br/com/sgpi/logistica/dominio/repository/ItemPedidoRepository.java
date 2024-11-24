package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<Item, Long> {
}
