package br.com.avaliacaoTecnica.repository;

import br.com.avaliacaoTecnica.entities.AssociateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity, Integer> {

}
