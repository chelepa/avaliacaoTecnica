package br.com.avaliacaoTecnica.dto.guidelines;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidelinesResponseDTO {

    private String id;
    private String Name;
    private String Description;
    private String Status;
    private String Time;

}
