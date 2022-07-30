package br.com.avaliacaoTecnica.dto.guidelines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidelinesRequestDTO {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private LocalDate expirationDate;

}
