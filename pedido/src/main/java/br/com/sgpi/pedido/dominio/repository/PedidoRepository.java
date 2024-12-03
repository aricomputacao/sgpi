package br.com.sgpi.pedido.dominio.repository;

import br.com.sgpi.pedido.dominio.enumeration.StatusPedido;
import br.com.sgpi.pedido.dominio.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Função: Informa ao Spring Data JPA que este método é uma operação de modificação no banco de dados (como update ou delete).
     * Necessidade: Em consultas @Query que não retornam dados (operações update ou delete),
     * o Spring precisa desse @Modifying para saber que não é uma operação de leitura.
     * clearAutomatically = true: Invalida o cache de contexto de persistência automaticamente após a execução
     * do método. Isso é útil para evitar inconsistências, especialmente se outros métodos ou operações dependerem do valor atualizado.
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(StatusPedido status, Pedido pedido);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens WHERE p.clienteIntegrado = false or p.estoqueValidado = false")
    List<Pedido> findAllByEstoqueValidadoFalseOrClienteIntegradoFalse();
}
