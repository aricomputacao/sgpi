package br.com.sgpi.logistica.apllication.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("cliente-ms")
public interface ClienteClient {
    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/cliente/{cpf}/comunicar-entrega")
    void comunicarEntrega(@PathVariable String cpf);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/cliente/{cpf}/comunicar-saida")
    void comunicarSaida(@PathVariable String cpf);
}
