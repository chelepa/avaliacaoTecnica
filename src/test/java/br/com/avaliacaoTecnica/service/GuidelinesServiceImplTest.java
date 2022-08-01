package br.com.avaliacaoTecnica.service;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.exceptions.DeleteGuidelinesException;
import br.com.avaliacaoTecnica.exceptions.StartGuidelinesException;
import br.com.avaliacaoTecnica.exceptions.UpdateGuidelinesException;
import br.com.avaliacaoTecnica.repository.GuidelinesRepository;
import br.com.avaliacaoTecnica.service.guidelines.GuidelinesServiceImpl;
import builder.AssociateServiceImplBuilder;
import builder.GuidelinesServiceImplBuilder;
import builder.VotingServiceImplBuilder;
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
public class GuidelinesServiceImplTest {

    @Mock
    private GuidelinesRepository repository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private GuidelinesServiceImpl guidelinesService;

    @Test
    public void GuidelinesResponseDTO_NotRuntime_When_createGuidelines() throws Exception {

        guidelinesService.createGuidelines(GuidelinesServiceImplBuilder.MockGuidelinesNotRuntimeRequest());

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void GuidelinesResponseDTO_When_createGuidelines() throws Exception {

        guidelinesService.createGuidelines(GuidelinesServiceImplBuilder.MockGuidelinesNotRequest());

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void GuidelinesResponseDTOList_When_getAllGuidelines() throws Exception {
        when(repository.findAll()).thenReturn(GuidelinesServiceImplBuilder.MockAssociateResponseList());

        List<GuidelinesResponseDTO> response = guidelinesService.getAllGuidelines();

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    public void GuidelinesResponseDTOList_When_getAllGuidelinesByStatus() throws Exception {
        when(repository.findByStatus(Mockito.any())).thenReturn(GuidelinesServiceImplBuilder.MockAssociateResponseList());

        List<GuidelinesResponseDTO> response = guidelinesService.getAllGuidelinesByStatus("RUNNING");

        Assertions.assertTrue(response.stream().allMatch(item -> item.getStatus().equalsIgnoreCase("RUNNING")));
    }

    @Test
    public void GuidelinesResponseDTOList_When_getGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse()));

        GuidelinesResponseDTO response = guidelinesService.getGuidelinesById(1);

        Assertions.assertEquals(1, response.getId());
    }

    @Test
    public void DeleteGuidelinesException_When_deleteGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse()));

        assertThrows(DeleteGuidelinesException.class, () -> {
            guidelinesService.deleteGuidelinesById(1);
        });
    }

    @Test
    public void Void_When_deleteGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse("CREATED")));

        guidelinesService.deleteGuidelinesById(1);

        verify(repository, times(1)).delete(Mockito.any());
    }

    @Test
    public void Void_When_updateGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse("CREATED")));

        guidelinesService.updateGuidelinesById(1, new GuidelinesRequestDTO("teste","teste 01",2));

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void UpdateGuidelinesException_When_updateGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse("RUNNING")));

        assertThrows(UpdateGuidelinesException.class, () -> {
            guidelinesService.updateGuidelinesById(1, new GuidelinesRequestDTO("teste","teste 01",2));
        });
    }

    @Test
    public void UpdateStartGuidelinesException_When_updateGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse("RUNNING")));

        assertThrows(StartGuidelinesException.class, () -> {
            guidelinesService.startGuidelines(1);
        });
    }

    @Test
    public void GuidelinesResponseDTO_When_updateGuidelinesById() throws Exception {
        when(repository.findById(Mockito.any())).thenReturn(Optional.of(GuidelinesServiceImplBuilder.MockGuidelinesEntityResponse("CREATED")));

        guidelinesService.startGuidelines(1);

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void GuidelinesResponseDTO_When_updateStatusGuidelines() throws Exception {
        guidelinesService.updateStatusGuidelines(GuidelinesServiceImplBuilder.MockGuidelinesResponseDTO());

        verify(repository, times(1)).save(Mockito.any());
    }
}
