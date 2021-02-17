package com.dbc.vitorfurini.assembleiadbc.validation;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;

public interface Validation {

    void validaAssociado(Associado associado);

    void validaCpf(String cpf);

}
