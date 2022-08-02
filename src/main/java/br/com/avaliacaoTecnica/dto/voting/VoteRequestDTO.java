package br.com.avaliacaoTecnica.dto.voting;

import lombok.Data;

@Data
public class VoteRequestDTO {

    private Integer idGuidelines;
    private Integer id;
    private String vote;

}
