package br.com.avaliacaoTecnica.exceptions;

public class UpdateGuidelinesException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UpdateGuidelinesException(String msg) {
        super(msg);
    }
}
