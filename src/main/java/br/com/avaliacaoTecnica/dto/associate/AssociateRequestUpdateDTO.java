package br.com.avaliacaoTecnica.dto.associate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AssociateRequestUpdateDTO {

    @NotNull
    @NotEmpty
    private String name;
}
