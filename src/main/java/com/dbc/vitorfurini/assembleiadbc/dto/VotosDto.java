package com.dbc.vitorfurini.assembleiadbc.dto;

import com.dbc.vitorfurini.assembleiadbc.enums.TipoVoto;

import java.io.Serializable;

public class VotosDto implements Serializable {

    private Long id;

    private Long idAssociado;

    private Long idAssembleia;

    private TipoVoto tipoVoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public Long getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(Long idAssociado) {
        this.idAssociado = idAssociado;
    }

    public Long getIdAssembleia() {
        return idAssembleia;
    }

    public void setIdAssembleia(Long idAssembleia) {
        this.idAssembleia = idAssembleia;
    }

    @Override
    public String toString() {
        return "VotosDto{"
                + "id=" + id
                + ", idAssociado=" + idAssociado
                + ", idAssembleia=" + idAssembleia
                + ", tipoVoto=" + tipoVoto
                + '}';
    }
}
