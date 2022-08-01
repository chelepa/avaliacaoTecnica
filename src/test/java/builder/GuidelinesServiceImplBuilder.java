package builder;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.util.TestUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
