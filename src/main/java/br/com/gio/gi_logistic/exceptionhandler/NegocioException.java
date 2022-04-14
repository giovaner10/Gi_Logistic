package br.com.gio.gi_logistic.exceptionhandler;

public class NegocioException extends RuntimeException{

    public NegocioException(String message) {
        super(message);
    }
}
