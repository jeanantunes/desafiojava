package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;
import br.com.desafio.repository.ProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetosService implements IProjetosService {

    @Autowired
    private ProjetosRepository projetosRepository;

    @Override
    public List<Projetos> getProjetosList() {
        return projetosRepository.findAll();
    }

    @Override
    public Optional<Projetos> getProjetosById(Long id) {
        return projetosRepository.findById(id);
    }

    @Override
    public void updateProjetos(Projetos projetos) {
        projetosRepository.save(projetos);
    }

    @Override
    public void addProjetos(String nome, Date dataInicio, Date dataPrevisaoFim, Date dataFim, String descricao, String status, float orcamento, String risco, Pessoa idGerente) {
        projetosRepository.save(new Projetos());
    }

    @Override
    public void deleteProjetos(Long id) {
        Optional<Projetos> projetos = projetosRepository.findById(id);
        if (projetos.isPresent()) {
            projetosRepository.delete(projetos.get());
        }
    }

    @Override
    public Projetos saveProjetos(Projetos projetos) {
        projetosRepository.save(projetos);
        return projetos;
    }
}
