package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(MockitoExtension.class)
public class AssociateControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AssociateController associateController;

    @Mock
    private AssociateService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(associateController).build();
    }

    @Test
    public void ValidateStatus_CREATED_When_createAssociate() throws Exception {
        when(service.createAssociate(Mockito.any())).thenReturn(new AssociateResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(post("/v1/associate").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.readJsonFile("json/CreateAssociate.json"))).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_getAllAssociate() throws Exception {
        when(service.getAllAssociate()).thenReturn(new ArrayList<>());

        MockHttpServletResponse response = mockMvc.perform(get("/v1/associate")).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_getAssociateByCpf() throws Exception {
        when(service.getAssociateByCpf(Mockito.any())).thenReturn(new AssociateResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(get("/v1/associate/{cpf}", "03300121001")).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_NO_CONTENT_When_deleteAssociateByCpf() throws Exception {
        Mockito.when(service.deleteAssociateByCpf(Mockito.any())).thenReturn(ResponseEntity.noContent().build());

        MockHttpServletResponse response = mockMvc.perform(delete("/v1/associate/{cpf}" , "03300121001").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_updateAssociateByCpf() throws Exception {
        Mockito.when(service.updateAssociate(Mockito.any(), Mockito.any())).thenReturn(new AssociateResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(patch("/v1/associate/{cpf}","03300121001")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.readJsonFile("json/UpdateAssociate.json"))).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
