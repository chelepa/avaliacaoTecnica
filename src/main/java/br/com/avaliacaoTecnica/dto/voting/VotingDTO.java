package br.com.avaliacaoTecnica.dto.voting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotingDTO {

    private String cpfAssociate;
    private Integer idGuidelines;
    private String vote;
}
