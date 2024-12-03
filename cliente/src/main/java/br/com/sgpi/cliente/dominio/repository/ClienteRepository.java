package br.com.sgpi.cliente.dominio.repository;

import br.com.sgpi.cliente.dominio.model.entity.Cliente;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Object> findByCpf(@CPF @NotEmpty String cpf);
}
