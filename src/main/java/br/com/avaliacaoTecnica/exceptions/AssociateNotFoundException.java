package br.com.avaliacaoTecnica.exceptions;

public class AssociateNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AssociateNotFoundException(String msg) {
        super(msg);
    }
}
