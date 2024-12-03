package br.com.sgpi.produto.application.util;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class Util {

    // Método para formatar mensagens de erro
    public String formatarMensagemErro(List<String> errosValidacao) {
        return "Erros de validação no arquivo: " + String.join("; ", errosValidacao);
    }

    // Método para salvar o arquivo temporário
    public Path salvarArquivoTemporario(MultipartFile arquivo) throws IOException {
        Path tempFile = Files.createTempFile(null, ".csv");
        Files.copy(arquivo.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        return tempFile;
    }

    // Método para executar o Job de importação
    public void executarJobImportacao(Path tempFile, JobLauncher jobLauncher, Job importarProduto)
            throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("arquivo.path", tempFile.toString())
                .toJobParameters();
        jobLauncher.run(importarProduto, jobParameters);
    }
}
