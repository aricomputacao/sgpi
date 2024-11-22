package br.com.sgpi.logistica.apllication.controller;

import br.com.sgpi.logistica.apllication.util.UriUtil;
import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.model.entity.Entregador;
import br.com.sgpi.logistica.dominio.model.mapper.EntregadorMapper;
import br.com.sgpi.logistica.dominio.service.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/entregador")
public class EntregadorController {

    private final EntregadorService entregadorService;
    private final EntregadorMapper entregadorMapper;

    @PostMapping
    @Operation(summary = "Cadastra uma novo Entregador.", method = "POST")
    public ResponseEntity<EntregadorDto> salvar(@RequestBody @Valid EntregadorDto entregadorDto) {
        entregadorDto = entregadorService.salvar(entregadorDto);
        return ResponseEntity.created(UriUtil.createUriWithId(entregadorDto.id())).body(entregadorDto);
    }

    @GetMapping()
    @Operation(summary = "Consultador todos os Entregadores.", method = "POST")
    public Page<EntregadorDto> consultaTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return  entregadorService.consultarTodos(paginacao);
    }

    @PatchMapping("/{id}")
    public void desativar(@PathVariable @NotNull Long id) {
        entregadorService.desativar(id);
    }

}
