package br.com.avaliacaoTecnica.dto.guidelines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidelinesResponseDTO {

    private Integer id;
    private String name;
    private String description;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private Boolean approved;
    private Integer amount_vote_yes;
    private Integer amount_vote_not;

}
