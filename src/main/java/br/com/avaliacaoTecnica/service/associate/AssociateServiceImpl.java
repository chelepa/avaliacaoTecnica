package br.com.avaliacaoTecnica.service.associate;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.repository.AssociateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AssociateServiceImpl implements AssociateService{

    @Autowired
    private AssociateRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssociateResponseDTO createAssociate(AssociateRequestDTO request) {

        AssociateEntity entity = modelMapper.map(request, AssociateEntity.class);

        repository.save(entity);

        AssociateResponseDTO response = modelMapper.map(entity, AssociateResponseDTO.class);

        return response;
    }
}
