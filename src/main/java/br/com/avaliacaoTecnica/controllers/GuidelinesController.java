package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.service.guidelines.GuidelinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class GuidelinesController {

    @Autowired
    private GuidelinesService service;

    @PostMapping(value = "/guidelines")
    public ResponseEntity<GuidelinesResponseDTO> createGuidelines(@Valid @RequestBody GuidelinesRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createGuidelines(request));
    }

    @GetMapping(value = "/guidelines")
    public ResponseEntity<List<GuidelinesResponseDTO>> getAllGuidelines() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllGuidelines());
    }

    @GetMapping(value = "/guidelines/{id}")
    public ResponseEntity<GuidelinesResponseDTO> getGuidelinesById(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.getGuidelinesById(id));
    }

    @DeleteMapping(value = "/guidelines/{id}")
    public ResponseEntity<Void> deleteGuidelinesById(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return service.deleteGuidelinesById(id);
    }

    @PatchMapping(value = "/guidelines/{id}")
    public ResponseEntity<GuidelinesResponseDTO> updateGuidelinesById(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody GuidelinesRequestDTO request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateGuidelinesById(id, request));
    }

    @PostMapping(value = "/guidelines/start/{id}")
    public ResponseEntity<GuidelinesResponseDTO> startGuidelines(@PathVariable(value = "id", required = true) Integer id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.startGuidelines(id));
    }

}
