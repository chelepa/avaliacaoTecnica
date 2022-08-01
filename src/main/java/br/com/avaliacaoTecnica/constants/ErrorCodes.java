package br.com.avaliacaoTecnica.constants;

public enum ErrorCodes {
    VOTE_ERROR("VoteException"),
    DELETE_GUIDELINES("Error Delete Guidelines"),
    ASSOCIATE_EXISTS("Associate Exists"),
    UPDATE_GUIDELINES_RUNNING("update guidelines running"),
    START_GUIDELINES("Start Guidelines"),
    MEMBER_HAS_ALREADY_VOTED("member has already voted"),
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
