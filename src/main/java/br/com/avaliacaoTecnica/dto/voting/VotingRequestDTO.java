package br.com.avaliacaoTecnica.dto.voting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VotingRequestDTO {

    @NotEmpty
    private String vote;
}
