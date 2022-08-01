package br.com.avaliacaoTecnica.service;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateRequestUpdateDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.exceptions.AssociateExistsException;
import br.com.avaliacaoTecnica.exceptions.AssociateNotFoundException;
import br.com.avaliacaoTecnica.repository.AssociateRepository;
import br.com.avaliacaoTecnica.service.associate.AssociateServiceImpl;
import builder.AssociateServiceImplBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssociateServiceTest {

    @Mock
    private AssociateRepository repository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private AssociateServiceImpl associateService;

    @Test
    public void AssociateResponseDTO_When_createAssociate() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.empty());

        AssociateResponseDTO response = associateService.createAssociate(new AssociateRequestDTO("03300121000" , "Claudimir chelepa"));

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void ExpectedAssociateExistsException_When_createAssociate() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(AssociateServiceImplBuilder.MockAssociateResponse());

        assertThrows(AssociateExistsException.class, () -> {
            associateService.createAssociate(new AssociateRequestDTO("03300121000" , "Claudimir chelepa"));
        });
    }

    @Test
    public void ListAssociateResponseDTO_When_getAllAssociate() throws Exception {
        when(repository.findAll()).thenReturn(AssociateServiceImplBuilder.MockAssociateResponseList());

        List<AssociateResponseDTO> response = associateService.getAllAssociate();

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    public void AssociateResponseDTO_When_getAssociateByCpf() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(AssociateServiceImplBuilder.MockAssociateResponse());

        AssociateResponseDTO response = associateService.getAssociateByCpf("03300121000");

        Assertions.assertEquals("03300121000", response.getCpf());
    }

    @Test
    public void AssociateNotFoundException_When_getAssociateByCpf() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.empty());

        assertThrows(AssociateNotFoundException.class, () -> {
            associateService.getAssociateByCpf("03300121000");
        });
    }

    @Test
    public void Void_When_deleteAssociateByCpf() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(AssociateServiceImplBuilder.MockAssociateResponse());

        associateService.deleteAssociateByCpf("03300121000");

        verify(repository, times(1)).delete(Mockito.any());
    }

    @Test
    public void AssociateResponseDTO_When_updateAssociate() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(AssociateServiceImplBuilder.MockAssociateResponse());

        associateService.updateAssociate("03300121000", new AssociateRequestUpdateDTO("claudimir chelepa"));

        verify(repository, times(1)).save(Mockito.any());
    }
}
