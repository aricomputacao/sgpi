package br.com.sgpi.pedido.dominio.service;

import br.com.sgpi.pedido.apllication.http.ClienteClient;
import br.com.sgpi.pedido.dominio.model.dto.ClienteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteService {

    private ClienteClient clienteClient;

    @CircuitBreaker(name = "clienteService", fallbackMethod = "fallbackConsultarCliente")
    public ClienteDto consultarClientePor(String cpfCliente) {
        ClienteDto clienteDto = clienteClient.consultarClientePor(cpfCliente);
        clienteDto.setClienteIntegrado(true);
        return clienteDto;
    }

    public ClienteDto fallbackConsultarCliente(String cpfCliente, Throwable ex) {
        log.warn("Executando fallbackConsultarCliente para cliente {}", cpfCliente);
        return ClienteDto.builder().clienteIntegrado(false).cpf(cpfCliente).build();
    }
}
