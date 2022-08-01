package br.com.avaliacaoTecnica.dto.voting;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class VotingRequestDTO {

    @NotEmpty
    private String vote;
}
