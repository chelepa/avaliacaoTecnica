package br.com.avaliacaoTecnica.dto.associate;

import br.com.avaliacaoTecnica.dto.voting.VoteRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class AssociateVoteResponseDTO {

    private String cpf;
    private String name;
    private List<VoteRequestDTO> vote;
}
