package com.dbc.vitorfurini.assembleiadbc.vo.request;

import com.dbc.vitorfurini.assembleiadbc.enums.TipoVoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VotosRequestVO implements Serializable {

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
}