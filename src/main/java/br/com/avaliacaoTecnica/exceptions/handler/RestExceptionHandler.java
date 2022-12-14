package br.com.avaliacaoTecnica.exceptions.handler;

import br.com.avaliacaoTecnica.constants.ErrorCodes;
import br.com.avaliacaoTecnica.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GuidelinesNotFoundException.class)
    public final ResponseEntity<Object> handleGuidelinesNotFoundException(GuidelinesNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.GUIDELINES_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(AssociateNotFoundException.class)
    public final ResponseEntity<Object> handleAssociateNotFoundException(AssociateNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.ASSOCIATE_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(UpdateGuidelinesException.class)
    public final ResponseEntity<Object> handleUpdateGuidelinesException(UpdateGuidelinesException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.UPDATE_GUIDELINES_RUNNING, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(StartGuidelinesException.class)
    public final ResponseEntity<Object> handleStartGuidelinesException(StartGuidelinesException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.START_GUIDELINES, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(MemberHasAlreadyVotedException.class)
    public final ResponseEntity<Object> handleMemberHasAlreadyVotedException(MemberHasAlreadyVotedException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.MEMBER_HAS_ALREADY_VOTED, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(AssociateExistsException.class)
    public final ResponseEntity<Object> handleAssociateExistsException(AssociateExistsException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.ASSOCIATE_EXISTS, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(DeleteGuidelinesException.class)
    public final ResponseEntity<Object> handleDeleteGuidelinesException(DeleteGuidelinesException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.DELETE_GUIDELINES, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(VoteException.class)
    public final ResponseEntity<Object> handleVoteException(VoteException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.VOTE_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(CanceledGuidelinesException.class)
    public final ResponseEntity<Object> handleCanceledGuidelinesException(CanceledGuidelinesException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.CANCELED_GUIDELINES_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
