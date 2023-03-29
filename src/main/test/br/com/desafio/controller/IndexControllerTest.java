package br.com.desafio.controller;

import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;
import br.com.desafio.repository.ProjetosRepository;
import br.com.desafio.service.IProjetosService;
import br.com.desafio.service.ProjetosService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    @InjectMocks
    ProjetosService projetosService;

    @Mock
    ProjetosRepository projetosRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initBinder() {
    }

    @Test
    void home() {
    }

    @Test
    public void showProjetos() {
        Projetos p1 = new Projetos();
        p1.setId(1L);
        p1.setNome("Nome Projeto");
        p1.setDataInicio(new Date());
        p1.setDataPrevisaoFim(new Date());
        p1.setDataFim(new Date());
        p1.setDescricao("descrição para o projeto");
        p1.setStatus("ATIVO");
        p1.setOrcamento(10000f);
        p1.setRisco("ALTO");
        p1.setIdGerente(2L);

        Projetos p2 = new Projetos();
        p2.setId(2L);
        p2.setNome("Nome Projeto 2");
        p2.setDataInicio(new Date());
        p2.setDataPrevisaoFim(new Date());
        p2.setDataFim(new Date());
        p2.setDescricao("descrição para o projeto 2");
        p2.setStatus("ATIVO");
        p2.setOrcamento(10000f);
        p2.setRisco("ALTO");
        p2.setIdGerente(2L);

        List<Projetos> projetosList = new ArrayList<>();
        projetosService.saveProjetos(p1);
        projetosService.saveProjetos(p2);
        projetosList.addAll(Arrays.asList(p1, p2));
        when(projetosRepository.findAll()).thenReturn(projetosList);

        List<Projetos> result = projetosService.getProjetosList();

        assertThat(result.size()).isEqualTo(projetosList.size());
        assertThat(result.get(0)).isEqualTo(projetosList.get(0));
        assertThat(result.get(1)).isEqualTo(projetosList.get(1));
    }

    @Test
    void deleteProjetos() {
        Projetos p1 = new Projetos();
        p1.setId(1L);
        p1.setNome("Nome Projeto");
        p1.setDataInicio(new Date());
        p1.setDataPrevisaoFim(new Date());
        p1.setDataFim(new Date());
        p1.setDescricao("descrição para o projeto");
        p1.setStatus("ATIVO");
        p1.setOrcamento(10000f);
        p1.setRisco("ALTO");
        p1.setIdGerente(2L);

        Projetos p2 = new Projetos();
        p2.setId(2L);
        p2.setNome("Nome Projeto 2");
        p2.setDataInicio(new Date());
        p2.setDataPrevisaoFim(new Date());
        p2.setDataFim(new Date());
        p2.setDescricao("descrição para o projeto 2");
        p2.setStatus("ATIVO");
        p2.setOrcamento(10000f);
        p2.setRisco("ALTO");
        p2.setIdGerente(2L);

        List<Projetos> projetosList = new ArrayList<>();
        projetosList.addAll(Arrays.asList(p1, p2));

        projetosRepository.deleteById(1L);

        projetosList = projetosRepository.findAll();
        assertThat(projetosList.size()).isEqualTo(0);
    }

    @Test
    void showUpdateProjetosPage() {
        Projetos p1 = new Projetos();
        p1.setId(1L);
        p1.setNome("Nome Projeto");
        p1.setDataInicio(new Date());
        p1.setDataPrevisaoFim(new Date());
        p1.setDataFim(new Date());
        p1.setDescricao("descrição para o projeto");
        p1.setStatus("ATIVO");
        p1.setOrcamento(10000f);
        p1.setRisco("ALTO");
        p1.setIdGerente(2L);

        Projetos p2 = new Projetos();
        p2.setId(2L);
        p2.setNome("Nome Projeto 2");
        p2.setDataInicio(new Date());
        p2.setDataPrevisaoFim(new Date());
        p2.setDataFim(new Date());
        p2.setDescricao("descrição para o projeto 2");
        p2.setStatus("ATIVO");
        p2.setOrcamento(10000f);
        p2.setRisco("ALTO");
        p2.setIdGerente(2L);

        p1.setNome("Projeto Updated");
        projetosService.updateProjetos(p1);

        String updatedProj = p1.getNome();
        assertEquals(p1.getNome(), updatedProj);
    }

    @Test
    void initSave() {
    }

    @Test
    void update() {
    }

    @Test
    void addProjetos() {
        Projetos p1 = new Projetos();
        p1.setId(1L);
        p1.setNome("Nome Projeto");
        p1.setDataInicio(new Date());
        p1.setDataPrevisaoFim(new Date());
        p1.setDataFim(new Date());
        p1.setDescricao("descrição para o projeto");
        p1.setStatus("ATIVO");
        p1.setOrcamento(10000f);
        p1.setRisco("ALTO");
        p1.setIdGerente(2L);

        Projetos p2 = new Projetos();
        p2.setId(2L);
        p2.setNome("Nome Projeto 2");
        p2.setDataInicio(new Date());
        p2.setDataPrevisaoFim(new Date());
        p2.setDataFim(new Date());
        p2.setDescricao("descrição para o projeto 2");
        p2.setStatus("ATIVO");
        p2.setOrcamento(10000f);
        p2.setRisco("ALTO");
        p2.setIdGerente(2L);

        projetosService.addProjetos(p1.getNome(), p1.getDataInicio(), p1.getDataPrevisaoFim(), p1.getDataFim(), p1.getDescricao(), p1.getStatus(), p1.getOrcamento(), p1.getRisco(), new Pessoa());

        when(projetosRepository.findById(1L)).thenReturn(Optional.of(p1));

        assertThat(projetosRepository.findById(1L)).isNotEmpty();
    }

    @Test
    void showPessoa() {
    }
}