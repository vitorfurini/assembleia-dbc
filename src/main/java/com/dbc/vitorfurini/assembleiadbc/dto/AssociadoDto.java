package com.dbc.vitorfurini.assembleiadbc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class AssociadoDto implements Serializable {


    private Long id;
    @NotNull(message = "O campo cpf é obrigatório e deve ser preenchido!")
    @JsonFormat(pattern = "cpf")
    private String cpf;
    @NotNull(message = "O campo nome é obrigatório e deve ser preenchido!")
    @JsonFormat(pattern = "nome")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AssociadoDto{"
                + "id=" + id
                + ", cpf='" + cpf + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
