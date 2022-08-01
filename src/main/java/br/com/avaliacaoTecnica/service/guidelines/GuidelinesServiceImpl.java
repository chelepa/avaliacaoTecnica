package br.com.avaliacaoTecnica.service.guidelines;

import br.com.avaliacaoTecnica.constants.StatusCode;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.entities.VoteEntity;
import br.com.avaliacaoTecnica.exceptions.GuidelinesNotFoundException;
import br.com.avaliacaoTecnica.exceptions.StartGuidelinesException;
import br.com.avaliacaoTecnica.exceptions.UpdateGuidelinesException;
import br.com.avaliacaoTecnica.repository.GuidelinesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        entity.setStatus(StatusCode.CREATED.getMessage());

        entity.setCreationDate(LocalDateTime.now());

        if (request.getRuntime() == null) {
            entity.setRuntime(1);
        }

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
    public List<GuidelinesResponseDTO> getAllGuidelinesByStatus(String status) {
        log.info("GuidelinesServiceImpl.getAllGuidelinesByStatus - Start - ");

        List<GuidelinesResponseDTO> response = new ArrayList<>();

        repository.findByStatus(status).forEach(entity -> response.add(guidelinesEntityTOGuidelinesResponseDTO(entity)));

        log.info("GuidelinesServiceImpl.getAllGuidelinesByStatus - End - GuidelinesResponseDTO: [{}]", response);

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

        if (entity.getStatus().equalsIgnoreCase(StatusCode.CREATED.getMessage())) {

            modelMapper.map(request, entity);

            repository.save(entity);
        } else {
            throw new UpdateGuidelinesException("Error Update Guidelines, Guidelines is running");
        }

        GuidelinesResponseDTO response = guidelinesEntityTOGuidelinesResponseDTO(entity);

        log.info("GuidelinesServiceImpl.updateGuidelinesById - End - response: [{}]", response);

        return response;
    }

    @Override
    public GuidelinesResponseDTO startGuidelines(Integer id) throws Exception {
        log.info("GuidelinesServiceImpl.startGuidelines - Start - ID: [{}]", id);

        GuidelinesEntity entity = findById(id);

        if (entity.getStatus().equalsIgnoreCase(StatusCode.CREATED.getMessage())) {

            entity.setStatus(StatusCode.RUNNING.getMessage());

            entity.setExpirationDate(LocalDateTime.now().plusMinutes(entity.getRuntime()));

            repository.save(entity);
        } else {
            throw new StartGuidelinesException(String.format("Error Start Guidelines id: [%s] - Status: [%s]", id, entity.getStatus()));
        }

        GuidelinesResponseDTO response = guidelinesEntityTOGuidelinesResponseDTO(entity);

        log.info("GuidelinesServiceImpl.startGuidelines - End - response: [{}]", response);

        return response;
    }

    @Override
    public GuidelinesResponseDTO updateStatusGuidelines(GuidelinesResponseDTO item) {
        log.info("GuidelinesServiceImpl.updateStatusGuidelines - Start - GuidelinesResponseDTO: [{}]", item);

        GuidelinesEntity entity = modelMapper.map(item, GuidelinesEntity.class);

        entity.setStatus(StatusCode.CLOSED.getMessage());

        repository.save(entity);

        GuidelinesResponseDTO response = guidelinesEntityTOGuidelinesResponseDTO(entity);

        log.info("GuidelinesServiceImpl.updateStatusGuidelines - End - GuidelinesResponseDTO: [{}]", response);

        return response;
    }

    public void updateApprovedAndAmountVote(GuidelinesResponseDTO item) throws Exception {
        GuidelinesEntity entity = findById(item.getId());
        long responseCountYes = entity.getVote().stream().filter(line -> line.getVote().equalsIgnoreCase("sim")).count();
        long responseCountNot = entity.getVote().stream().filter(line -> line.getVote().equalsIgnoreCase("não")).count();
        Boolean approved = (responseCountYes > responseCountNot) ? Boolean.TRUE : Boolean.FALSE;
        entity.setApproved(approved);
        entity.setAmount_vote_not(Long.valueOf(responseCountNot).intValue());
        entity.setAmount_vote_yes(Long.valueOf(responseCountYes).intValue());
        repository.save(entity);
    }

    private GuidelinesResponseDTO guidelinesEntityTOGuidelinesResponseDTO(GuidelinesEntity entity) {
        return modelMapper.map(entity, GuidelinesResponseDTO.class);
    }

    private GuidelinesEntity findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new GuidelinesNotFoundException(String.format("Guidelines Not Found - id: [%s] ", id)));
    }
}
