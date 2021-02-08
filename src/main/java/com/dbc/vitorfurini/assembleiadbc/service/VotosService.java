package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Votos;

import java.util.List;

public interface VotosService {

    List<Votos> listAll();

    Votos save(Votos voto);
}
