package repository;

import entities.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotosRepository extends JpaRepository<Votos, Long> {
}
