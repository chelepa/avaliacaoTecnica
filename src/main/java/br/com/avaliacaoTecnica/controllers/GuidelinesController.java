package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesRequestDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class GuidelinesController {

    @PostMapping(value = "/guidelines")
    public ResponseEntity<GuidelinesResponseDTO> createGuidelines(@Valid @RequestBody GuidelinesRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value = "/guidelines/start/{id}")
    public ResponseEntity<GuidelinesResponseDTO> startGuidelines(@PathVariable(value = "id", required = true) Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value = "/guidelines")
    public ResponseEntity<List<GuidelinesResponseDTO>> getAllGuidelines() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value = "/guidelines/{id}")
    public ResponseEntity<GuidelinesResponseDTO> getGuidelinesById(@PathVariable(value = "id", required = true) Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "/guidelines/{id}")
    public ResponseEntity<Void> deleteGuidelinesById(@PathVariable(value = "id", required = true) Integer id) {
        return null;
    }

    @PatchMapping(value = "/guidelines/{id}")
    public ResponseEntity<GuidelinesResponseDTO> updateGuidelinesById(@PathVariable(value = "id", required = true) Integer id, @Valid @RequestBody GuidelinesRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
