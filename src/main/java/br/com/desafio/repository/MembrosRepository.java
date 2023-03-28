package br.com.desafio.repository;

import br.com.desafio.model.Membros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, Long> {
}
