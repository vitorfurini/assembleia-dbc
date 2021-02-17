package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;

import java.util.List;
import java.util.Optional;

public interface PautaService {

    List<Pauta> listAll();

    Pauta novaPauta(Pauta pauta);

    Optional<Pauta> findById(Long pauta);
}
