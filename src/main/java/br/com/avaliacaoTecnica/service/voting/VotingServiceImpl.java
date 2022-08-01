package br.com.avaliacaoTecnica.service.voting;

import br.com.avaliacaoTecnica.constants.StatusCode;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.dto.voting.VotingRequestDTO;
import br.com.avaliacaoTecnica.dto.voting.VotingResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.entities.VoteEntity;
import br.com.avaliacaoTecnica.repository.VotingRepository;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
import br.com.avaliacaoTecnica.service.guidelines.GuidelinesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private AssociateService associateService;

    @Autowired
    private GuidelinesService guidelinesService;

    @Autowired
    private VotingRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VotingResponseDTO createdVoteByCpfById(String CPF, Integer id, VotingRequestDTO request) throws Exception {

        AssociateEntity associate = getAssociateByCpfResponseAssociateEntity(CPF);

        GuidelinesEntity guidelinesentity = getGuidelinesByIdResponseGuidelinesEntity(id);

        if (isVotingByCpf(associate, guidelinesentity)){
            return new VotingResponseDTO("Usuario Ja Votou nessa Pauta");
        } else {
            populateVote(associate, guidelinesentity, request);

            return new VotingResponseDTO("Voto contabilizado com Sucesso");
        }
    }

    private void populateVote(AssociateEntity associate, GuidelinesEntity guidelinesentity, VotingRequestDTO request) {
        if (guidelinesentity.getStatus().equalsIgnoreCase(StatusCode.RUNNING.getMessage())){
            LocalDateTime dateNow = LocalDateTime.now();
            LocalDateTime dateExpiration = guidelinesentity.getExpirationDate();

            if (dateNow.compareTo(dateExpiration) <= 0){
                VoteEntity entity = new VoteEntity();
                entity.setCpfAssociate(associate);
                entity.setIdGuidelines(guidelinesentity);
                entity.setVote(request.getVote());
                repository.save(entity);
            }
        }
    }

    private Boolean isVotingByCpf(AssociateEntity associate, GuidelinesEntity guidelinesentity) {
        Optional<VoteEntity> response = repository.findByCpfAssociateAndIdGuidelines(associate, guidelinesentity);
        return (response.isEmpty()) ? Boolean.FALSE : Boolean.TRUE;
    }

    private GuidelinesEntity getGuidelinesByIdResponseGuidelinesEntity(Integer id) throws Exception {
        GuidelinesResponseDTO guidelines = guidelinesService.getGuidelinesById(id);

        return modelMapper.map(guidelines, GuidelinesEntity.class);

    }

    private AssociateEntity getAssociateByCpfResponseAssociateEntity(String CPF) throws Exception {

        AssociateResponseDTO dto = associateService.getAssociateByCpf(CPF);

        return modelMapper.map(dto, AssociateEntity.class);
    }
}
