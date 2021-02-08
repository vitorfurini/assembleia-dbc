package com.dbc.vitorfurini.assembleiadbc.repository;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssembleiaRepository extends JpaRepository<Assembleia, Long> {
}
