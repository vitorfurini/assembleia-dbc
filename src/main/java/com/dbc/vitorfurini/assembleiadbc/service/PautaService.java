package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;

import java.util.List;

public interface PautaService {

    List<Pauta> listarAll();

    Pauta novaPauta(Pauta pauta);
}
