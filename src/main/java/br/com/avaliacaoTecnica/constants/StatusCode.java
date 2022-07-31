package br.com.avaliacaoTecnica.constants;

public enum StatusCode {
    RUNNING("running"),
    CREATED("created"),
    CLOSED("closed");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}