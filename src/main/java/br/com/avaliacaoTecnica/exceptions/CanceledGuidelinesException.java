package br.com.avaliacaoTecnica.exceptions;

public class CanceledGuidelinesException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CanceledGuidelinesException(String msg) {
        super(msg);
    }
}
