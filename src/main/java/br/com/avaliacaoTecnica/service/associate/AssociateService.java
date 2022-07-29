package br.com.avaliacaoTecnica.service.associate;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;

public interface AssociateService {

    AssociateResponseDTO createAssociate(AssociateRequestDTO request);
}
