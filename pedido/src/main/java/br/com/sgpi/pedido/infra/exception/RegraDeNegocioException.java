package br.com.sgpi.pedido.infra.exception;

public class RegraDeNegocioException extends RuntimeException {

    public RegraDeNegocioException(String message) {
        super(message);
    }

}
