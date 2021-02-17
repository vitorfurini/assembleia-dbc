package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;

import java.util.List;

public interface AssembleiaService {

    List<Assembleia> listAll();

    Assembleia novaAssembleia(Assembleia assembleia);

}
