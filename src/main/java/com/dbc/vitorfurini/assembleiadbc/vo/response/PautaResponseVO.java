package com.dbc.vitorfurini.assembleiadbc.vo.response;


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
public class PautaResponseVO  implements Serializable {

    private Long id;
    private String nomePauta;
    private String descricaoPauta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePauta() {
        return nomePauta;
    }

    public void setNomePauta(String nomePauta) {
        this.nomePauta = nomePauta;
    }

    public String getDescricaoPauta() {
        return descricaoPauta;
    }

    public void setDescricaoPauta(String descricaoPauta) {
        this.descricaoPauta = descricaoPauta;
    }
}
