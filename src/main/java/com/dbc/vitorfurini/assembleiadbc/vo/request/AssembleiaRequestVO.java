package com.dbc.vitorfurini.assembleiadbc.vo.request;

import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssembleiaRequestVO implements Serializable {

    private Long id;
    private String name;
    private String descricaoAssembleia;
    private Long duracao;
    @NotNull(message = "O ID da pauta é obrigatório")
    private Long idPauta;
    private StatusAssembleia statusAssembleia;

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

    public String getDescricaoAssembleia() {
        return descricaoAssembleia;
    }

    public void setDescricaoAssembleia(String descricaoAssembleia) {
        this.descricaoAssembleia = descricaoAssembleia;
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

    public StatusAssembleia getStatusAssembleia() {
        return statusAssembleia;
    }

    public void setStatusAssembleia(StatusAssembleia statusAssembleia) {
        this.statusAssembleia = statusAssembleia;
    }
}