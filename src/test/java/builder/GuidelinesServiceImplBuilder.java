package builder;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.entities.VoteEntity;
import br.com.avaliacaoTecnica.util.TestUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuidelinesServiceImplBuilder {

    public static GuidelinesRequestDTO MockGuidelinesNotRuntimeRequest() throws IOException {
        GuidelinesRequestDTO teste = new GuidelinesRequestDTO();
        teste.setName("name");
        teste.setDescription("description");
        return teste;
    }

    public static GuidelinesRequestDTO MockGuidelinesNotRequest() throws IOException {
        GuidelinesRequestDTO teste = new GuidelinesRequestDTO();
        teste.setName("name");
        teste.setDescription("description");
        teste.setRuntime(10);
        return teste;
    }

    public static GuidelinesEntity MockGuidelinesEntityResponse(String status) throws IOException {
        GuidelinesEntity respose = TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesEntity.class);
        respose.setStatus(status);
        return respose;
    }

    public static GuidelinesEntity MockGuidelinesEntityResponse() throws IOException {
        return TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesEntity.class);
    }

    public static GuidelinesResponseDTO MockGuidelinesResponseDTO() throws IOException {
        return TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesResponseDTO.class);
    }

    public static List<GuidelinesEntity> MockAssociateResponseList() throws IOException {
        List<GuidelinesEntity> response = new ArrayList<>();
        response.add(MockGuidelinesEntityResponse());
        return response;
    }

    public static Optional<GuidelinesEntity> MockGuidelinesEntityResponseVote() throws IOException {
        List<AssociateEntity> associateEntity = new ArrayList<>();
        AssociateEntity response = new AssociateEntity();
        response.setCpf("03300121000");
        response.setName("Claudimir Chelepa");

        associateEntity.add(response);

        List<VoteEntity> listVoteEntity = new ArrayList<>();
        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setId(1);
        voteEntity.setIdGuidelines(MockGuidelinesEntityResponse());
        voteEntity.setCpfAssociate(response);
        voteEntity.setVote("SIM");
        listVoteEntity.add(voteEntity);

        GuidelinesEntity respose = TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesEntity.class);
        respose.setVote(listVoteEntity);
        return Optional.of(respose);
    }

    public static Optional<GuidelinesEntity> MockGuidelinesEntityResponseVote(String Status) throws IOException {
        List<AssociateEntity> associateEntity = new ArrayList<>();
        AssociateEntity response = new AssociateEntity();
        response.setCpf("03300121000");
        response.setName("Claudimir Chelepa");

        associateEntity.add(response);

        List<VoteEntity> listVoteEntity = new ArrayList<>();
        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setId(1);
        voteEntity.setIdGuidelines(MockGuidelinesEntityResponse());
        voteEntity.setCpfAssociate(response);
        voteEntity.setVote("SIM");
        listVoteEntity.add(voteEntity);

        GuidelinesEntity respose = TestUtil.getObjectFromFile("json/GuidelinesResponse.json", GuidelinesEntity.class);
        respose.setVote(listVoteEntity);
        respose.setStatus(Status);
        return Optional.of(respose);
    }
}
