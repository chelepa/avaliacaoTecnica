package br.com.avaliacaoTecnica.constants;

public enum StatusCode {
    RUNNING("RUNNING"),
    CREATED("CREATED"),
    CANCELED("CANCELED"),
    CLOSED("CLOSED");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}