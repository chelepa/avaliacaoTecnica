package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.voting.VotingRequestDTO;
import br.com.avaliacaoTecnica.dto.voting.VotingResponseDTO;
import br.com.avaliacaoTecnica.service.voting.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class VotingController {

    @Autowired
    private VotingService service;

    @PostMapping(value = "/voting/{CPF}/{id}")
    public ResponseEntity<VotingResponseDTO> createVoting(@PathVariable(value = "CPF", required = true) String CPF,
                                                              @PathVariable(value = "id", required = true) Integer id,
                                                              @Valid @RequestBody VotingRequestDTO request) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.createdVoteByCpfById(CPF, id, request));
    }

}
