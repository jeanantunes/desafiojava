package br.com.desafio.service;

import br.com.desafio.model.Membros;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;

import java.util.List;
import java.util.Optional;

public interface IMembrosService {

    List<Membros> getMembrosList();

    Optional<Membros> getMembrosById(Long id);

    void updateMembros(Membros membros);

    void addMembros(Projetos projetosId, Pessoa pessoaId);

    void deleteMembros(Long id);

    void saveMembros(Membros membros);
}
