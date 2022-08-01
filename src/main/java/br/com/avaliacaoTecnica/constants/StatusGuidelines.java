package br.com.avaliacaoTecnica.constants;

public enum StatusGuidelines {
    APPROVED("APPROVED"),
    DISAPPROVED("DISAPPROVED"),
    DRAWS("DRAWS");

    private final String message;

    StatusGuidelines(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
