package br.com.sgpi.produto.Entity;

import br.com.sgpi.produto.dominio.model.entity.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
public class ProdutoTest {

    @Test
    void deveCriarProduto() {
        Produto produto = new Produto(1L, "Produto A", "Descrição A", new BigDecimal(10.0), 5);

        assertEquals(1L, produto.getId());
        assertEquals("Produto A", produto.getNome());
        assertEquals("Descrição A", produto.getDescricao());
        assertEquals( new BigDecimal(10.0), produto.getPreco());
        assertEquals(5, produto.getQuantidadeEstoque());
    }
}
