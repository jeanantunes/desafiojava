package br.com.desafio.service;

import br.com.desafio.model.Pessoa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPessoaService {

    List<Pessoa> getPessoaList();

    Optional<Pessoa> getPessoaById(Long id);

    void updatePessoa(Pessoa pessoa);

    void addPessoa(String nome, Date dataNascimento, String cpf, boolean funcionario, String pessoaCol);

    void deletePessoa(Long id);

    void savePessoa(Pessoa pessoa);
}
