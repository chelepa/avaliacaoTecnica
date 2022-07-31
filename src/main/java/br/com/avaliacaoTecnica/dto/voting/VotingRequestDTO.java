package br.com.avaliacaoTecnica.dto.voting;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class VotingRequestDTO {

    @NotEmpty
    @Size(min = 3, max = 3, message = "user name should have at least 2 characters")
    private String vote;
}
