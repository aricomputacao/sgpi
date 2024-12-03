package br.com.sgpi.pedido.apllication.http;

import br.com.sgpi.pedido.dominio.model.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cliente-ms")
public interface ClienteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/cliente/cpf/{cpf}")
    ClienteDto consultarClientePor(@PathVariable String cpf);
}
