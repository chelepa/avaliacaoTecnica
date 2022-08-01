package br.com.avaliacaoTecnica.exceptions;

import br.com.avaliacaoTecnica.exceptions.handler.RestExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

@ExtendWith(MockitoExtension.class)
public class RestExceptionHandlerTest {

    @Mock
    private WebRequest request;

    @InjectMocks
    private RestExceptionHandler restExceptionHandler;

    @Test
    public void handleGuidelinesNotFoundException() {
        GuidelinesNotFoundException response = new GuidelinesNotFoundException("guidelinesNotFoundException");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, restExceptionHandler.handleGuidelinesNotFoundException(response, request).getStatusCode());
    }

    @Test
    public void handleAssociateNotFoundException() {
        AssociateNotFoundException response = new AssociateNotFoundException("AssociateNotFoundException");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, restExceptionHandler.handleAssociateNotFoundException(response, request).getStatusCode());
    }

    @Test
    public void handleUpdateGuidelinesException() {
        UpdateGuidelinesException response = new UpdateGuidelinesException("UpdateGuidelinesException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleUpdateGuidelinesException(response, request).getStatusCode());
    }

    @Test
    public void handleStartGuidelinesException() {
        StartGuidelinesException response = new StartGuidelinesException("StartGuidelinesException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleStartGuidelinesException(response, request).getStatusCode());
    }

    @Test
    public void handleMemberHasAlreadyVotedException() {
        MemberHasAlreadyVotedException response = new MemberHasAlreadyVotedException("MemberHasAlreadyVotedException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleMemberHasAlreadyVotedException(response, request).getStatusCode());
    }

    @Test
    public void handleAssociateExistsException() {
        AssociateExistsException response = new AssociateExistsException("AssociateExistsException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleAssociateExistsException(response, request).getStatusCode());
    }

    @Test
    public void handleDeleteGuidelinesException() {
        DeleteGuidelinesException response = new DeleteGuidelinesException("DeleteGuidelinesException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleDeleteGuidelinesException(response, request).getStatusCode());
    }

    @Test
    public void handleVoteException() {
        VoteException response = new VoteException("VoteException");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, restExceptionHandler.handleVoteException(response, request).getStatusCode());
    }
}
