package br.com.avaliacaoTecnica.exceptions;

public class VoteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public VoteException(String msg) {
        super(msg);
    }
}
