package br.com.avaliacaoTecnica.dto.associate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssociateRequestDTO {

    @NotNull
    @NotEmpty
    private String cpf;

    @NotNull
    @NotEmpty
    private String name;
}
