package br.com.avaliacaoTecnica.constants;

public enum ErrorCodes {
    UPDATE_GUIDELINES_RUNNING("update guidelines running"),
    START_GUIDELINES("Start Guidelines"),
    GUIDELINES_NOT_FOUND("Guidelines Not Found"),
    ASSOCIATE_NOT_FOUND("Associate Not Found");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
