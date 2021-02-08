package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;

import java.util.List;
import java.util.Optional;

public interface AssembleiaService {

    List<Assembleia> listAll();

    Assembleia novaAssembleia(Assembleia assembleia);

    Optional<Assembleia> findByIdPauta(Pauta pauta);
}
