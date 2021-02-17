package com.dbc.vitorfurini.assembleiadbc.repository;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

    Optional<Pauta> findById(Long id);

}
