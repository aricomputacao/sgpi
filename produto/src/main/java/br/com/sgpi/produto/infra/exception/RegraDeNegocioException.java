package br.com.sgpi.produto.infra.exception;

public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException(String message) {
        super(message);
    }

}
