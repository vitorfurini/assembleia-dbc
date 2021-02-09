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

}
