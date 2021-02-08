package com.dbc.vitorfurini.assembleiadbc.dto;

import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class AssembleiaDto implements Serializable {

    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone ="America/São Paulo")
    private Date data;
    private Long duracao;
    @NotNull(message = "O ID da pauta é obrigatório")
    private Long idPauta;
    private String nomePauta;
    private String descricao;
    private StatusAssembleia statusAssembleia;

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

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusAssembleia getStatusAssembleia() {
        return statusAssembleia;
    }

    public void setStatusAssembleia(StatusAssembleia statusAssembleia) {
        this.statusAssembleia = statusAssembleia;
    }

    public String getNomePauta() {
        return nomePauta;
    }

    public void setNomePauta(String nomePauta) {
        this.nomePauta = nomePauta;
    }

    @Override
    public String toString() {
        return "AssembleiaDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", data=" + data
                + ", duracao=" + duracao
                + ", idPauta=" + idPauta
                + ", nomePauta='" + nomePauta + '\''
                + ", descricao='" + descricao + '\''
                + ", statusAssembleia=" + statusAssembleia
                + '}';
    }
}
