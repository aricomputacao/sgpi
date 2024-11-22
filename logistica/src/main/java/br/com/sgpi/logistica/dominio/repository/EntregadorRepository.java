package br.com.sgpi.logistica.dominio.repository;

import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
}
