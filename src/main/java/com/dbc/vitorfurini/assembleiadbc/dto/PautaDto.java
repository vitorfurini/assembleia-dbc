package com.dbc.vitorfurini.assembleiadbc.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PautaDto implements Serializable {

    private Long id;

    @NotNull(message = "O campo nome é obrigatório e deve ser preenchido!")
    @NotEmpty(message = "O campo nome não pode ficar vazio!")
    private String name;

    @NotNull(message = "O campo descrição é obrigatório e deve ser preenchido!")
    @NotEmpty(message = "O campo descrição não pode ficar vazio!")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "PautaDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", descricao='" + descricao + '\''
                + '}';
    }
}
