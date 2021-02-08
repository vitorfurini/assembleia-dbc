package repository;

import entities.Votos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Long> {

    Votos findByAssociadoId(Long idAssociado);
}
