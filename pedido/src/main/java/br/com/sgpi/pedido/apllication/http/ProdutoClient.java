package br.com.sgpi.pedido.apllication.http;

import br.com.sgpi.pedido.dominio.model.dto.ProdutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("produto-ms")
public interface ProdutoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/produto/existe/{id}")
    boolean existeProduto(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/produto/{id}")
    ProdutoDto buscarProduto(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/produto/baixar/{id}/{quantidade}")
    ProdutoDto baixarEstoque(@PathVariable Long id, @PathVariable Integer quantidade);


}
