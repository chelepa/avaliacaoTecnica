package builder;

import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.entities.VoteEntity;
import br.com.avaliacaoTecnica.util.TestUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

public class VotingServiceImplBuilder {

    public static AssociateResponseDTO MockAssociateResponse() throws IOException {
        return TestUtil.getObjectFromFile("json/CreateAssociate.json", AssociateResponseDTO.class);
    }

    public static GuidelinesResponseDTO MockGuidelinesResponse() throws IOException {
        GuidelinesResponseDTO response =  TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesResponseDTO.class);
        response.setExpirationDate(LocalDateTime.now().plusMinutes(1));
        return response;
    }

    public static Optional<VoteEntity> MockVoteEntity() throws IOException {
        VoteEntity response =  new VoteEntity();
        response.setId(1);
        response.setCpfAssociate(new AssociateEntity());
        response.setIdGuidelines(new GuidelinesEntity());
        response.setVote("SIM");
        return Optional.of(response);
    }


}
