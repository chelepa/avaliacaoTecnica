package br.com.avaliacaoTecnica.repository;

import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuidelinesRepository extends JpaRepository<GuidelinesEntity, Integer> {

    List<GuidelinesEntity> findByStatus(String status);

}
