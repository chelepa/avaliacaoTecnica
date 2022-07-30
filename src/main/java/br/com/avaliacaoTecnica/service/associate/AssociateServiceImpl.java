package br.com.avaliacaoTecnica.service.associate;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.repository.AssociateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AssociateServiceImpl implements AssociateService{

    @Autowired
    private AssociateRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssociateResponseDTO createAssociate(AssociateRequestDTO request) {
        log.info("AssociateServiceImpl.createAssociate - Start - AssociateResponseDTO: [{}]", request);

        AssociateEntity entity = modelMapper.map(request, AssociateEntity.class);

        repository.save(entity);

        AssociateResponseDTO response = modelMapper.map(entity, AssociateResponseDTO.class);

        log.info("AssociateServiceImpl.createAssociate - End - AssociateResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public List<AssociateResponseDTO> getAllAssociate() {
        log.info("AssociateServiceImpl.getAllAssociate - Start - ");

        List<AssociateResponseDTO> response = new ArrayList<>();

        repository.findAll().forEach(entity -> response.add(associateEntityTOAssociateResponseDTO(entity)));

        log.info("AssociateServiceImpl.getAllAssociate - End - AssociateResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public AssociateResponseDTO getAssociateByCpf(String CPF) throws Exception {
        log.info("AssociateServiceImpl.getAssociateByCpf - Start - CPF: [{}]", CPF);

        AssociateEntity entity = findByCpf(CPF);

        AssociateResponseDTO response = associateEntityTOAssociateResponseDTO(entity);

        log.info("AssociateServiceImpl.getAssociateByCpf - Start - AssociateResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public ResponseEntity<Void> deleteAssociateByCpf(String CPF) throws Exception {
        log.info("AssociateServiceImpl.deletedeleteAssociateByCpf - Start - CPF: [{}]", CPF);

        AssociateEntity entity = findByCpf(CPF);

        repository.delete(entity);

        log.info("AssociateServiceImpl.deletedeleteAssociateByCpf - End - CPF: [{}]", CPF);

        return ResponseEntity.noContent().build();
    }

    @Override
    public AssociateResponseDTO updateAssociate(String CPF, AssociateRequestDTO request) throws Exception {
        log.info("AdditionAndFinesService.updateAdditionAndFines - Start - request: {}", request);

        AssociateEntity entity = findByCpf(CPF);
        request.setCpf(CPF);

        modelMapper.map(request, entity);
        repository.save(entity);

        AssociateResponseDTO response = associateEntityTOAssociateResponseDTO(entity);

        log.info("AdditionAndFinesService.updateAdditionAndFines - End - response: {}", response);

        return response;
    }

    private AssociateResponseDTO associateEntityTOAssociateResponseDTO(AssociateEntity entity) {
        return modelMapper.map(entity, AssociateResponseDTO.class);
    }

    private AssociateEntity findByCpf(String CPF) throws Exception {
        return repository.findById(CPF).orElseThrow(() -> new Exception(String.format("Associate Not Found - CPF: %s ", CPF)));
    }
}
