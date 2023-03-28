package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import br.com.desafio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements IPessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Override
    public List<Pessoa> getPessoaList() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> getPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void updatePessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    @Override
    public void addPessoa(String nome, String pessoaCol) {
        pessoaRepository.save(new Pessoa());
    }

    @Override
    public void deletePessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            pessoaRepository.delete(pessoa.get());
        }
    }

    @Override
    public void savePessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}
