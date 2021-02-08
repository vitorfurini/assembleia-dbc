package com.dbc.vitorfurini.assembleiadbc.dto;

import java.io.Serializable;
import java.util.Date;

public class AssembleiaDto  implements Serializable {

    private Long id;
    private Date data;
    private Long duracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "AssembleiaDto{"
                + "id=" + id
                + ", data=" + data
                + ", duracao=" + duracao
                + '}';
    }
}
