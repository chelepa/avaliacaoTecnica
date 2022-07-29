package br.com.avaliacaoTecnica.dto.guidelines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidelinesRequestDTO {

    @NotNull
    private String Name;
    @NotNull
    private String Description;
    private String Status;
    @NotNull
    private String Time;

}
