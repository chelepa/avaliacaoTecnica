package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.associate.AssociateRequestDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateRequestUpdateDTO;
import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class AssociateController {

    @Autowired
    private AssociateService service;

    @PostMapping(value = "/associate")
    public ResponseEntity<AssociateResponseDTO> createAssociate(@Valid @RequestBody AssociateRequestDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAssociate(request));
    }

    @GetMapping(value = "/associate")
    public ResponseEntity<List<AssociateResponseDTO>> getAllAssociate() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAssociate());
    }

    @GetMapping(value = "/associate/{cpf}")
    public ResponseEntity<AssociateResponseDTO> getAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAssociateByCpf(cpf));
    }

    @DeleteMapping(value = "/associate/{cpf}")
    public ResponseEntity<Void> deleteAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf) throws Exception {
        return service.deleteAssociateByCpf(cpf);
    }

    @PatchMapping(value = "/associate/{cpf}")
    public ResponseEntity<AssociateResponseDTO> updateAssociateByCpf(@PathVariable(value = "cpf", required = true) String cpf, @Valid @RequestBody AssociateRequestUpdateDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAssociate(cpf, request));
    }
}
