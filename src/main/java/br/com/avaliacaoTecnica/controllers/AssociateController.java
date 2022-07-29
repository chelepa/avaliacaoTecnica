package br.com.avaliacaoTecnica.controllers;


import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class AssociateController {

//    @Autowired
//    private AssociateService service;

    @PostMapping(value = "/associate")
    public ResponseEntity<AssociateResponseDTO> createAssociate(@RequestBody AssociateRequestDTO request) {
        System.out.println(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping(value = "/associate")
    public ResponseEntity<List<AssociateResponseDTO>> getAllAssociate() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value = "/associate/{cpf}")
    public ResponseEntity<AssociateResponseDTO> getAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "/associate/{cpf}")
    public ResponseEntity<Void> deleteAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf) {
        return null;
    }

    @PatchMapping(value = "/associate/{cpf}")
    public ResponseEntity<AssociateResponseDTO> updateAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf, @RequestBody AssociateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
