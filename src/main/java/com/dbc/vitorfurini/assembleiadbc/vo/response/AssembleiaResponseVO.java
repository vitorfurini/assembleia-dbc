package com.dbc.vitorfurini.assembleiadbc.vo.response;

import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssembleiaResponseVO implements Serializable {


    private Long id;
    private String name;
    private String descricaoAssembleia;
    private Long duracao;
    private String data;
    private Long idPauta;
    private String nomePauta;
    private String descricaoPauta;
    private StatusAssembleia statusAssembleia;
}