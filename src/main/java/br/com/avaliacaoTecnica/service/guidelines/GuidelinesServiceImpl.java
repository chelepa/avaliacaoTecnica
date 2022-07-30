package br.com.avaliacaoTecnica.service.guidelines;

import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.exceptions.UpdateGuidelinesException;
import br.com.avaliacaoTecnica.repository.GuidelinesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GuidelinesServiceImpl implements GuidelinesService {

    @Autowired
    private GuidelinesRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GuidelinesResponseDTO createGuidelines(GuidelinesRequestDTO request) {
        log.info("GuidelinesServiceImpl.createGuidelines - Start - GuidelinesRequestDTO: [{}]", request);

        GuidelinesEntity entity = modelMapper.map(request, GuidelinesEntity.class);
        entity.setStatus("created");
        entity.setCreationDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        repository.save(entity);

        GuidelinesResponseDTO response = modelMapper.map(entity, GuidelinesResponseDTO.class);

        log.info("GuidelinesServiceImpl.createGuidelines - End - GuidelinesResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public List<GuidelinesResponseDTO> getAllGuidelines() {
        log.info("GuidelinesServiceImpl.getAllGuidelines - Start - ");

        List<GuidelinesResponseDTO> response = new ArrayList<>();

        repository.findAll().forEach(entity -> response.add(guidelinesEntityTOGuidelinesResponseDTO(entity)));

        log.info("GuidelinesServiceImpl.getAllGuidelines - End - GuidelinesResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public GuidelinesResponseDTO getGuidelinesById(Integer Id) throws Exception {
        log.info("GuidelinesServiceImpl.getGuidelinesById - Start - Id: [{}]", Id);

        GuidelinesEntity entity = findById(Id);

        GuidelinesResponseDTO response = guidelinesEntityTOGuidelinesResponseDTO(entity);

        log.info("GuidelinesServiceImpl.getGuidelinesById - Start - GuidelinesResponseDTO: [{}]", response);

        return response;
    }

    @Override
    public ResponseEntity<Void> deleteGuidelinesById(Integer Id) throws Exception {
        log.info("GuidelinesServiceImpl.deleteGuidelinesById - Start - ID: [{}]", Id);

        GuidelinesEntity entity = findById(Id);

        repository.delete(entity);

        log.info("GuidelinesServiceImpl.deleteGuidelinesById - End - ID: [{}]", Id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public GuidelinesResponseDTO updateGuidelinesById(Integer Id, GuidelinesRequestDTO request) throws Exception {
        log.info("GuidelinesServiceImpl.updateGuidelinesById - Start - ID: [{}] request: [{}]", Id, request);

        GuidelinesEntity entity = findById(Id);

        if (entity.getStatus().equalsIgnoreCase("created")) {

            modelMapper.map(request, entity);

            repository.save(entity);
        } else {
            throw new UpdateGuidelinesException("Error Update Guidelines, Guidelines is running");
        }

        GuidelinesResponseDTO response = guidelinesEntityTOGuidelinesResponseDTO(entity);

        log.info("GuidelinesServiceImpl.updateGuidelinesById - End - response: [{}]", response);

        return response;
    }

    private GuidelinesResponseDTO guidelinesEntityTOGuidelinesResponseDTO(GuidelinesEntity entity) {
        return modelMapper.map(entity, GuidelinesResponseDTO.class);
    }

    private GuidelinesEntity findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception(String.format("Guidelines Not Found - ID: %s ", id)));
    }
}
