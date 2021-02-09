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
}