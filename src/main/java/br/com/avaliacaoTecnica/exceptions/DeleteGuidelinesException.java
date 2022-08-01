package br.com.avaliacaoTecnica.exceptions;

public class DeleteGuidelinesException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DeleteGuidelinesException(String msg) {
        super(msg);
    }
}
