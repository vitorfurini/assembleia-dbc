package com.dbc.vitorfurini.assembleiadbc.dto;

import java.io.Serializable;

public class VotosDto implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Votos{"
                + "id=" + id
                + '}';
    }
}
