package br.com.avaliacaoTecnica.service;

import br.com.avaliacaoTecnica.dto.voting.VotingRequestDTO;
import br.com.avaliacaoTecnica.dto.voting.VotingResponseDTO;
import br.com.avaliacaoTecnica.exceptions.MemberHasAlreadyVotedException;
import br.com.avaliacaoTecnica.exceptions.VoteException;
import br.com.avaliacaoTecnica.repository.VotingRepository;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
import br.com.avaliacaoTecnica.service.guidelines.GuidelinesService;
import br.com.avaliacaoTecnica.service.voting.VotingServiceImpl;
import builder.VotingServiceImplBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VotingServiceImplTest {

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private VotingServiceImpl votingService;

    @Mock
    private AssociateService associateService;

    @Mock
    private GuidelinesService guidelinesService;

    @Mock
    private VotingRepository repository;

    @Test
    public void ShouldVotingResponseDTO_When_createdVoteByCpfById() throws Exception {
        when(associateService.getAssociateByCpf(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockAssociateResponse());
        when(guidelinesService.getGuidelinesById(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockGuidelinesResponse());

        VotingResponseDTO response = votingService.createdVoteByCpfById("03300121000", 1, new VotingRequestDTO("SIM"));

        verify(repository, times(1)).save(Mockito.any());
    }

    @Test
    public void ExpectedMemberHasAlreadyVotedException_When_createdVoteByCpfById() throws Exception {
        when(associateService.getAssociateByCpf(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockAssociateResponse());
        when(guidelinesService.getGuidelinesById(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockGuidelinesResponse());
        when(repository.findByCpfAssociateAndIdGuidelines(Mockito.any(), Mockito.any())).thenReturn(VotingServiceImplBuilder.MockVoteEntity());

        assertThrows(MemberHasAlreadyVotedException.class, () -> {
            votingService.createdVoteByCpfById("03300121000", 1, new VotingRequestDTO("SIM"));
        });
    }

    @Test
    public void ExpectedVoteException_When_createdVoteByCpfById() throws Exception {
        when(associateService.getAssociateByCpf(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockAssociateResponse());
        when(guidelinesService.getGuidelinesById(Mockito.any())).thenReturn(VotingServiceImplBuilder.MockGuidelinesResponse());

        assertThrows(VoteException.class, () -> {
            votingService.createdVoteByCpfById("03300121000", 1, new VotingRequestDTO("tes"));
        });
    }
}
