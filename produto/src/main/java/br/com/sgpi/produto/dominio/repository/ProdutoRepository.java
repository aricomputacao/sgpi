package br.com.sgpi.produto.dominio.repository;

import br.com.sgpi.produto.dominio.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
