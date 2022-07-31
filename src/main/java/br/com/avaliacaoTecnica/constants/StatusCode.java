package br.com.avaliacaoTecnica.constants;

public enum StatusCode {
    RUNNING("running"),
    CREATED("created"),
    FINISHED("finished");

    private final String message;

    StatusCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}