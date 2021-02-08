package com.dbc.vitorfurini.assembleiadbc.repository;

import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Long> {

}
