package br.com.avaliacaoTecnica.constants;

public enum ErrorCodes {
    UPDATE_GUIDELINES_RUNNING("update guidelines running");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
