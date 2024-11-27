package br.com.sgpi.logistica.apllication.controller;

import br.com.sgpi.logistica.apllication.util.UriUtil;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.service.PedidoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pedido")
@Slf4j
public class PedidoController {

    private PedidoService service;

    @GetMapping()
    public List<PedidoDto> listarTodos() {
        return service.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> listarPorId(@PathVariable @NotNull Long id) {
        PedidoDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PedidoDto> criarPedido(@RequestBody @Valid PedidoDto dto) {
        PedidoDto pedidoRealizado = service.criarPedido(dto);
        return ResponseEntity.created(UriUtil.createUriWithId(pedidoRealizado.getId())).body(pedidoRealizado);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<PedidoDto> atualizaStatus(@PathVariable Long id, @RequestBody StatusPedido status) {
        PedidoDto dto = service.atualizaStatus(id, status);
        return ResponseEntity.ok(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{idPedido}/{idEntregador}/alocar")
    @CircuitBreaker(name = "comunicarSaida", fallbackMethod = "pedidoAlocadoSemComunicarAoCliente")
    public void alocarPedido(@PathVariable Long idPedido, @PathVariable Long idEntregador) {
        service.alocarPedido(idPedido, idEntregador);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/entregar")
    @CircuitBreaker(name = "comunicarEntrega", fallbackMethod = "pedidoEntregueSemComunicarAoCliente")
    public void entregarPedido(@PathVariable @NotNull Long id) {
        service.entregarPedido(id);
    }

    public void pedidoAlocadoSemComunicarAoCliente(Long idPedido, Long idEntregador, Exception e) {
        service.pedidoAlocadoSemComunicarAoCliente(idPedido, idEntregador, e);
        log.info("Executando fallbackMethod: pedidoAlocadoSemComunicarAoCliente para Pedido: {} e Entregador: {} ",
                idPedido, idEntregador);
    }

    public void pedidoEntregueSemComunicarAoCliente(Long id, Exception e) {
        service.pedidoEntregueSemComunicarAoCliente(id, e);
        log.info("Executando fallbackMethod: pedidoEntregueSemComunicarAoCliente para Pedido: {} ", id);
    }
}
