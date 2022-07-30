package br.com.avaliacaoTecnica.exceptions.handler;

import br.com.avaliacaoTecnica.constants.ErrorCodes;
import br.com.avaliacaoTecnica.exceptions.ExceptionResponse;
import br.com.avaliacaoTecnica.exceptions.UpdateGuidelinesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UpdateGuidelinesException.class)
    public final ResponseEntity<Object> handleUpdateGuidelinesException(UpdateGuidelinesException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.UPDATE_GUIDELINES_RUNNING, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}
