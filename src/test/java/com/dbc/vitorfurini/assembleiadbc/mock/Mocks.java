package com.dbc.vitorfurini.assembleiadbc.mock;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mocks {

    Pauta pauta = new Pauta();

    public Assembleia getAssembleia() {
        return Assembleia.builder()
                .id(10L)
                .name("Assembleia da geral do grêmio")
                .dataCriacao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
                .descricaoAssembleia("Assembleia para discutir se devemos permitir a volta do R10 ao Tricolor")
                .duracao(2L)
                .statusAssembleia(StatusAssembleia.ABERTA)
                .pauta(pauta)
                .build();
    }


}
