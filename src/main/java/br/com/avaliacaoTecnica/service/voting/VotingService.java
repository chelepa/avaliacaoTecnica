package br.com.avaliacaoTecnica.service.voting;

import br.com.avaliacaoTecnica.dto.voting.VotingRequestDTO;
import br.com.avaliacaoTecnica.dto.voting.VotingResponseDTO;

public interface VotingService {

    VotingResponseDTO createdVoteByCpfById(String CPF, Integer id, VotingRequestDTO request) throws Exception;
}
