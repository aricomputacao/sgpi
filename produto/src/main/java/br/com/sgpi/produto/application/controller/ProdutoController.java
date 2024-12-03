package br.com.sgpi.produto.application.controller;

import br.com.sgpi.produto.application.util.Util;
import br.com.sgpi.produto.dominio.model.dto.ProdutoRequestDTO;
import br.com.sgpi.produto.dominio.model.dto.ProdutoResponseDTO;
import br.com.sgpi.produto.dominio.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    private ProdutoService produtoService;
    private Util util;
    private JobLauncher jobLauncher;
    private Job importarProduto;

    @GetMapping
    public ResponseEntity<Page<ProdutoResponseDTO>> getAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        Page<ProdutoResponseDTO> produtos = produtoService.listarProdutos(pageable);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {
        var produto = produtoService.buscarProduto(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/existe/{id}")
    public boolean existById(@PathVariable Long id) {
        return produtoService.existeProduto(id);
    }

    @PostMapping("/carga")
    public ResponseEntity<String> carga(@RequestParam("arquivo") MultipartFile arquivo) {
        // Valida a estrutura do arquivo
        List<String> errosValidacao = produtoService.validarEstruturaArquivo(arquivo);
        if (!errosValidacao.isEmpty()) {
            return ResponseEntity.badRequest().body(util.formatarMensagemErro(errosValidacao));
        }
        try {
            // Cria o arquivo temporário
            Path tempFile = util.salvarArquivoTemporario(arquivo);

            // Executa o Job com os parâmetros configurados
            util.executarJobImportacao(tempFile, jobLauncher, importarProduto);

            return ResponseEntity.ok("Processamento iniciado com sucesso!");
        } catch (IOException e) {
            log.error("Erro ao manipular o arquivo: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar o arquivo: " + e.getMessage());
        } catch (JobExecutionException e) {
            log.error("Erro ao executar o job: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao iniciar o processamento: " + e.getMessage());
        }
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        var produto = produtoService.salvarProduto(produtoRequestDTO);
        return ResponseEntity.ok(produto);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        var produto = produtoService.atualizarProduto(id, produtoRequestDTO);
        return ResponseEntity.ok(produto);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> delete(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/baixar/{id}/{quantidade}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ProdutoResponseDTO> baixarEstoque(@PathVariable @NotNull Long id, @PathVariable @NotNull Integer quantidade) {
        ProdutoResponseDTO produtoResponseDTO = produtoService.baixarEstoque(id, quantidade);
        return ResponseEntity.ok(produtoResponseDTO);
    }

}

