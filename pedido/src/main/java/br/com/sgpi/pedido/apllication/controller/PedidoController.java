package br.com.sgpi.pedido.apllication.controller;

import br.com.sgpi.pedido.apllication.util.UriUtil;
import br.com.sgpi.pedido.dominio.enumeration.StatusPedido;
import br.com.sgpi.pedido.dominio.model.dto.PedidoRequestDto;
import br.com.sgpi.pedido.dominio.model.dto.PedidoResponseDto;
import br.com.sgpi.pedido.dominio.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    private PedidoService service;

    @GetMapping()
    public Page<PedidoResponseDto> listarTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> listarPorId(@PathVariable @NotNull Long id) {
        PedidoResponseDto dto = service.obterPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<PedidoResponseDto> realizaPedido(@RequestBody @Valid PedidoRequestDto dto) {
         PedidoResponseDto pedidoRealizado = service.criarPedido(dto);
        return ResponseEntity.created(UriUtil.createUriWithId(pedidoRealizado.getId())).body(pedidoRealizado);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PedidoRequestDto> atualizaStatus(@PathVariable Long id, @RequestBody StatusPedido status) {
        PedidoRequestDto dto = service.atualizaStatus(id, status);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/pago")
    public ResponseEntity<Void> aprovaPagamento(@PathVariable @NotNull Long id) {
        service.aprovaPagamentoPedido(id);
        return ResponseEntity.ok().build();
    }
}
