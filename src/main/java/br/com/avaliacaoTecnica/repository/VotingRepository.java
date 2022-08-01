package br.com.avaliacaoTecnica.repository;

import br.com.avaliacaoTecnica.entities.AssociateEntity;
import br.com.avaliacaoTecnica.entities.GuidelinesEntity;
import br.com.avaliacaoTecnica.entities.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<VoteEntity, Integer> {

    Optional<VoteEntity> findByCpfAssociateAndIdGuidelines(AssociateEntity cpf, GuidelinesEntity id);
}
