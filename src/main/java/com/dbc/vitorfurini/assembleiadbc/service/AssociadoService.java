package com.dbc.vitorfurini.assembleiadbc.service;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;

import java.util.List;

public interface AssociadoService {

    List<Associado> listAll();

    Associado findByCpf(String associado);

    Associado novoAssociado(Associado associado);
}
