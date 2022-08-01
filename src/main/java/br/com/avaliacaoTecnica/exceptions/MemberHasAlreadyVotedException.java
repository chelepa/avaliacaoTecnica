package br.com.avaliacaoTecnica.exceptions;

public class MemberHasAlreadyVotedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MemberHasAlreadyVotedException(String msg) {
        super(msg);
    }
}
