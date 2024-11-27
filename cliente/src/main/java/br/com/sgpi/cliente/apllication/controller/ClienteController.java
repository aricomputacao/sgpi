package br.com.sgpi.cliente.apllication.controller;


import br.com.sgpi.cliente.apllication.util.UriUtil;
import br.com.sgpi.cliente.dominio.model.dto.ClienteDto;
import br.com.sgpi.cliente.dominio.model.entity.Cliente;
import br.com.sgpi.cliente.dominio.model.mapper.ClienteMapper;
import br.com.sgpi.cliente.dominio.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteMapper clienteMapper;
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Consultar todos os Clientes.", method = "GET")
    public Page<ClienteDto> consultarTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return clienteService.consultarTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> listarPorId(@PathVariable @NotNull Integer id) {
        ClienteDto dto = clienteService.consultarUmCliente(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteDto cliente) {
        ClienteDto dto = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.created(UriUtil.createUriWithId(dto.id())).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Integer id,
                                                       @RequestBody @Valid ClienteDto novoCliente) {
        Cliente clienteSalvo = clienteService.atualizarCliente(novoCliente);
        return ResponseEntity.ok(clienteMapper.entityToDto(clienteSalvo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable Integer id) {
        clienteService.exluirCliente(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{cpf}/comunicar-entrega")
    public void comunicarEntrega(@PathVariable String cpf){
        System.out.println(String.format("Requisição respondida pela instância executando na porta %s", cpf));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{cpf}/comunicar-saida")
    public void comunicarSaida(@PathVariable String cpf){
        System.out.println(String.format("Requisição respondida pela instância executando na porta %s", cpf));
    }
}
