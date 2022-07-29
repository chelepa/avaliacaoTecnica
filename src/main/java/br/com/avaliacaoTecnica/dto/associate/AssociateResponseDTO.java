package br.com.avaliacaoTecnica.dto.associate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssociateResponseDTO {

    private String id;
    private String cpf;
    private String name;
}
