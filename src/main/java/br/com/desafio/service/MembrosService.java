package br.com.desafio.service;

import br.com.desafio.model.Membros;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projetos;
import br.com.desafio.repository.MembrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembrosService implements IMembrosService {

    @Autowired
    private MembrosRepository membrosRepository;
    @Override
    public List<Membros> getMembrosList() {
        return membrosRepository.findAll();
    }

    @Override
    public Optional<Membros> getMembrosById(Long id) {
        return membrosRepository.findById(id);
    }

    @Override
    public void updateMembros(Membros membros) {
        membrosRepository.save(membros);
    }

    @Override
    public void addMembros(Projetos projetosId, Pessoa pessoaId) {
        membrosRepository.save(new Membros());
    }

    @Override
    public void deleteMembros(Long id) {
        Optional<Membros> membros = membrosRepository.findById(id);
        if(membros.isPresent()){
            membrosRepository.delete(membros.get());
        }
    }

    @Override
    public void saveMembros(Membros membros) {
        membrosRepository.save(membros);
    }
}
