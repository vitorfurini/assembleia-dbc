package com.dbc.vitorfurini.assembleiadbc.repository;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    Associado findByCpfAssociado(String cpfAssociado);

}
