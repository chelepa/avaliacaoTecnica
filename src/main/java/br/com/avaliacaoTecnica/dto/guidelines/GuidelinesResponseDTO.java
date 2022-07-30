package br.com.avaliacaoTecnica.dto.guidelines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidelinesResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private LocalDate date_creation;
    private LocalDate date_expiration;
    private Boolean approved;
    private Integer amount_vote_yes;
    private Integer amount_vote_not;

}
