package br.com.avaliacaoTecnica.exceptions;

public class GuidelinesNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GuidelinesNotFoundException(String msg) {
        super(msg);
    }
}
