package br.com.sgpi.logistica.apllication.controller;

import br.com.sgpi.logistica.apllication.util.UriUtil;
import br.com.sgpi.logistica.dominio.enumeration.StatusPedido;
import br.com.sgpi.logistica.dominio.model.dto.PedidoDto;
import br.com.sgpi.logistica.dominio.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pedido")
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
    public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid PedidoDto dto) {
        PedidoDto pedidoRealizado = service.criarPedido(dto);
        return ResponseEntity.created(UriUtil.createUriWithId(pedidoRealizado.getId())).body(pedidoRealizado);
    }

    @PutMapping("/{idPedido}/{idEntregador}/alocar")
    public ResponseEntity<PedidoDto> alocarPEdido(@PathVariable Long idPedido, @PathVariable Long idEntregador) {
        PedidoDto dto = service.alocarPedido(idPedido, idEntregador);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<PedidoDto> atualizaStatus(@PathVariable Long id, @RequestBody StatusPedido status) {
        PedidoDto dto = service.atualizaStatus(id, status);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/entregar")
    public ResponseEntity<Void> entregarPedido(@PathVariable @NotNull Long id) {
        service.entregarPedido(id);
        return ResponseEntity.ok().build();
    }
}
