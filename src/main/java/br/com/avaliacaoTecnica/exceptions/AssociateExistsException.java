package br.com.avaliacaoTecnica.exceptions;

public class AssociateExistsException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AssociateExistsException(String msg) {
        super(msg);
    }
}
