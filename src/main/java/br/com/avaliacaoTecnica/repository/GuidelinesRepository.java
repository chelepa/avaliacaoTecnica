package br.com.avaliacaoTecnica.repository;

import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuidelinesRepository extends JpaRepository<GuidelinesEntity, Integer> {

}
