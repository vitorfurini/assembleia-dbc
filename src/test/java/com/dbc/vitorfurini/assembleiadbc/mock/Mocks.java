package com.dbc.vitorfurini.assembleiadbc.mock;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import com.dbc.vitorfurini.assembleiadbc.enums.TipoVoto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

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
    public List<Assembleia> getListAssembleias() {
        return Collections.singletonList(Assembleia.builder().build());
    }

    public Associado getAssociado() {
        return Associado.builder()
                .cpfAssociado("12345678912")
                .id(1L)
                .nomeAssociado("Vitor Furini")
                .build();
    }

    public List<Associado> getListAssociados() {
        return Collections.singletonList(Associado.builder().build());
    }

    public Pauta getPauta(){
        return Pauta.builder()
                .id(1L)
                .nomePauta("R10")
                .descricaoPauta("Pauta para assembleia de votação do R10")
                .build();
    }

    public List<Pauta> getListPautas() {
        return Collections.singletonList(Pauta.builder().build());
    }

    public Votos getVotos(){
        return Votos.builder().id(1L)
                .assembleia(this.getAssembleia())
                .associado(this.getAssociado())
                .tipoVoto(TipoVoto.SIM).build();
    }

    public List<Votos> getListVotos() {
        return Collections.singletonList(Votos.builder().build());
    }

}
