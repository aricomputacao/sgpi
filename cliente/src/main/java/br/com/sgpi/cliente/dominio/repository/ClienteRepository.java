package br.com.sgpi.cliente.dominio.repository;

import br.com.sgpi.cliente.dominio.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
