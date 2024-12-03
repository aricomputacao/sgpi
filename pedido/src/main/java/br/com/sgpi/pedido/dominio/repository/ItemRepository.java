package br.com.sgpi.pedido.dominio.repository;

import br.com.sgpi.pedido.dominio.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
}
