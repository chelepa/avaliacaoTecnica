package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.voting.VotingResponseDTO;
import br.com.avaliacaoTecnica.service.voting.VotingService;
import br.com.avaliacaoTecnica.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class VotingControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private VotingController votingController;

    @Mock
    private VotingService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(votingController).build();
    }

    @Test
    public void ValidateStatus_OK_When_createVoting() throws Exception {
        when(service.createdVoteByCpfById(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(new VotingResponseDTO("OK"));

        MockHttpServletResponse response = mockMvc.perform(post("/v1/voting/{CPF}/{id}", "03300121000", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.readJsonFile("json/CreateVoting.json"))).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
