package br.com.avaliacaoTecnica.repository;

import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuidelinesRepository extends JpaRepository<GuidelinesEntity, Integer> {

}
