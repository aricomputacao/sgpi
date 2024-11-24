package br.com.sgpi.logistica.apllication.controller;

import br.com.sgpi.logistica.dominio.model.dto.EntregadorDto;
import br.com.sgpi.logistica.dominio.repository.EntregadorRepository;
import br.com.sgpi.logistica.util.DadosErroValidacao;
import br.com.sgpi.logistica.util.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = {"/clean.sql",
        "/data_entregador.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class EntregadorControllerTest {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveConsultarEntregador() throws Exception {
        mockMvc.perform(get("/api/v1/entregador"))
                .andExpect(status().isOk()) // Verificar status da resposta
                .andExpect(jsonPath("$.content", hasSize(greaterThan(0)))); // Verifica se a lista tem elementos
    }

    @Test
    void deveRegistrarEntregador() throws Exception {
        EntregadorDto entregadorDto = Util.gerarEntregadorDto();

        MockHttpServletResponse response = mockMvc.perform(
                post("/api/v1/entregador")
                        .content(objectMapper.writeValueAsString(entregadorDto))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        //ASSERT
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    void naoDeveRegistrarEntregadorCodigo400NomeInvalido() throws Exception {
        EntregadorDto entregadorDto = Util.gerarEntregadorDtoInvalido();
        MockHttpServletResponse response = mockMvc.perform(
                post("/api/v1/entregador")
                        .content(objectMapper.writeValueAsString(entregadorDto))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        List<DadosErroValidacao> dadosErroValidacaoList = objectMapper.readValue(response.getContentAsString(),
                new TypeReference<List<DadosErroValidacao>>() {
                });

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
        assertEquals("nome", dadosErroValidacaoList.get(0).campo());
    }
}