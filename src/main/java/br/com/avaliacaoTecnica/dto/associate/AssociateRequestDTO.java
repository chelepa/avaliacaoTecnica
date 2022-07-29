package br.com.avaliacaoTecnica.dto.associate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociateRequestDTO {

    @NotNull
    private String CPF;

    @NotNull
    private String Name;
}
