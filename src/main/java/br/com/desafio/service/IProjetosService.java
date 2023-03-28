package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IProjetosService {

    List<Projetos> getProjetosList();

    Optional<Projetos> getProjetosById(Long id);

    void updateProjetos(Projetos projetos);

    void addProjetos(String nome, Date dataInicio, Date dataPrevisaoFim, Date dataFim, String descricao, String status, float orcamento, String risco, Pessoa idGerente);

    void deleteProjetos(Long id);

    Projetos saveProjetos(Projetos projetos);

    void saveNewProjeto(Projetos projetos);
}
