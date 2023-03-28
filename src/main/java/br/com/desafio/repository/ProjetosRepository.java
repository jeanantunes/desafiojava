package br.com.desafio.repository;

import br.com.desafio.model.Projetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetosRepository extends JpaRepository<Projetos, Long> {
}
