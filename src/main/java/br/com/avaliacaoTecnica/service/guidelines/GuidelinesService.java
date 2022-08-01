package br.com.avaliacaoTecnica.service.guidelines;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuidelinesService {

    GuidelinesResponseDTO createGuidelines(GuidelinesRequestDTO request);

    List<GuidelinesResponseDTO> getAllGuidelines();

    GuidelinesResponseDTO getGuidelinesById(Integer Id) throws Exception;

    ResponseEntity<Void> deleteGuidelinesById(Integer Id) throws Exception;

    GuidelinesResponseDTO updateGuidelinesById(Integer Id, GuidelinesRequestDTO request) throws Exception;

    GuidelinesResponseDTO startGuidelines(Integer id) throws Exception;

    List<GuidelinesResponseDTO> getAllGuidelinesByStatus(String status);

    GuidelinesResponseDTO updateStatusGuidelines(GuidelinesResponseDTO item);

    void updateApprovedAndAmountVote(Integer id) throws Exception;
}
