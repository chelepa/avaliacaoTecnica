package br.com.avaliacaoTecnica.service.associate;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateRequestUpdateDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AssociateService {

    AssociateResponseDTO createAssociate(AssociateRequestDTO request) throws Exception;

    List<AssociateResponseDTO> getAllAssociate();

    AssociateResponseDTO getAssociateByCpf(String CPF) throws Exception;

    ResponseEntity<Void> deleteAssociateByCpf(String CPF) throws Exception;

    AssociateResponseDTO updateAssociate(String CPF, AssociateRequestUpdateDTO request) throws Exception;
}
