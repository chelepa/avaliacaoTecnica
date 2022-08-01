package br.com.avaliacaoTecnica.controllers;

import br.com.avaliacaoTecnica.dto.associate.AssociateResponseDTO;
import br.com.avaliacaoTecnica.dto.guidelines.GuidelinesResponseDTO;
import br.com.avaliacaoTecnica.service.associate.AssociateService;
import br.com.avaliacaoTecnica.service.guidelines.GuidelinesService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

@ExtendWith(MockitoExtension.class)
public class GuidelinesControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GuidelinesController guidelinesController;

    @Mock
    private GuidelinesService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(guidelinesController).build();
    }

    @Test
    public void ValidateStatus_CREATED_When_createGuidelines() throws Exception {
        when(service.createGuidelines(Mockito.any())).thenReturn(new GuidelinesResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(post("/v1/guidelines").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.readJsonFile("json/CreateGuidelines.json"))).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_getAllGuidelines() throws Exception {
        when(service.getAllGuidelines()).thenReturn(new ArrayList<>());

        MockHttpServletResponse response = mockMvc.perform(get("/v1/guidelines")).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_getGuidelinesById() throws Exception {
        when(service.getGuidelinesById(Mockito.any())).thenReturn(new GuidelinesResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(get("/v1/guidelines/{id}", 1)).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_NO_CONTENT_When_deleteGuidelinesById() throws Exception {
        Mockito.when(service.deleteGuidelinesById(Mockito.any())).thenReturn(ResponseEntity.noContent().build());

        MockHttpServletResponse response = mockMvc.perform(delete("/v1/guidelines/{id}" , 1).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        Assertions.assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }

    @Test
    public void ValidateStatus_OK_When_updateAssociateByCpf() throws Exception {
        Mockito.when(service.updateGuidelinesById(Mockito.any(), Mockito.any())).thenReturn(new GuidelinesResponseDTO());

        MockHttpServletResponse response = mockMvc.perform(patch("/v1/guidelines/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.readJsonFile("json/UpdateGuidelines.json"))).andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
