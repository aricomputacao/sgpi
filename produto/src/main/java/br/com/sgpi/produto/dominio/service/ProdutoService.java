package br.com.sgpi.produto.dominio.service;

import br.com.sgpi.produto.dominio.model.dto.ProdutoRequestDTO;
import br.com.sgpi.produto.dominio.model.dto.ProdutoResponseDTO;
import br.com.sgpi.produto.dominio.model.entity.Produto;
import br.com.sgpi.produto.dominio.repository.ProdutoRepository;
import br.com.sgpi.produto.infra.exception.RegraDeNegocioException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Page<ProdutoResponseDTO> listarProdutos(Pageable pageable) {
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos.map(ProdutoResponseDTO::toDTO);
    }

    public ProdutoResponseDTO buscarProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Produto não encontrado"));

        return ProdutoResponseDTO.toDTO(produto);
    }

    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRequestDTO.toEntity();
        produto = produtoRepository.save(produto);
        return ProdutoResponseDTO.toDTO(produto);
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Produto com o ID " + id + " não encontrado."));

        try {
            produto.setNome(produtoRequestDTO.nome());
            produto.setDescricao(produtoRequestDTO.descricao());
            produto.setQuantidadeEstoque(produtoRequestDTO.quantidadeEstoque());
            produto.setPreco(produtoRequestDTO.preco());
            produto = produtoRepository.save(produto);
        } catch (EntityNotFoundException e) {
            throw new RegraDeNegocioException("Não foi possivel atualizar o produto");
        }
        return ProdutoResponseDTO.toDTO(produto);
    }

    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.getReferenceById(id);
        produtoRepository.deleteById(id);
    }

    public List<String> validarEstruturaArquivo(MultipartFile arquivo) {
        List<String> erros = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo.getInputStream()))) {
            String header = reader.readLine();
            if (header == null || !header.equals("nome,descricao,preco,quantidadeEstoque")) {
                erros.add("Cabeçalho inválido. Esperado: nome,descricao,preco,quantidadeEstoque");
            }

            String linha;
            int linhaNumero = 1;
            while ((linha = reader.readLine()) != null) {
                linhaNumero++;
                String[] campos = linha.split(",");

                if (campos.length != 4) {
                    erros.add("Linha " + linhaNumero + " deve ter 4 colunas");
                    continue;
                }

                if (campos[0].isBlank()) {
                    erros.add("Linha " + linhaNumero + ": nome é obrigatório");
                }

                try {
                    Double.parseDouble(campos[2]);
                } catch (NumberFormatException e) {
                    erros.add("Linha " + linhaNumero + ": preco deve ser um número válido");
                }

                try {
                    int quantidade = Integer.parseInt(campos[3]);
                    if (quantidade < 0) {
                        erros.add("Linha " + linhaNumero + ": quantidadeEstoque deve ser um valor positivo");
                    }
                } catch (NumberFormatException e) {
                    erros.add("Linha " + linhaNumero + ": quantidadeEstoque deve ser um número inteiro");
                }
            }
        } catch (Exception e) {
            erros.add("Erro ao ler o arquivo: " + e.getMessage());
        }
        return erros;
    }

    public boolean existeProduto(Long id) {
        return produtoRepository.existsById(id);
    }

    public ProdutoResponseDTO baixarEstoque(@NotNull Long id, @NotNull Integer quantidade) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Produto não encontrado"));
        produto.baixarEstoque(quantidade);
        return ProdutoResponseDTO.toDTO(produto);
    }
}
