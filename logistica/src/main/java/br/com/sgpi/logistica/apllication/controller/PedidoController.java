package br.com.sgpi.logistica.apllication.controller;

import br.com.sgpi.logistica.apllication.util.UriUtil;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.service.ClienteService;
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

    private final PedidoService service;
    private final ClienteService clienteService;

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
    public void alocarPedido(@PathVariable Long idPedido, @PathVariable Long idEntregador) {
        clienteService.alocarPedido(idPedido, idEntregador);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/entregar")
    public void entregarPedido(@PathVariable @NotNull Long id) {
        clienteService.entregarPedido(id);
    }

}
