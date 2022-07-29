package br.com.avaliacaoTecnica.dto.associate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociateResponseDTO {

    private String id;
    private String CPF;
    private String Name;
}
