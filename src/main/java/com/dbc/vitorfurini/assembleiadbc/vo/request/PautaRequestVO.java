package com.dbc.vitorfurini.assembleiadbc.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PautaRequestVO  implements Serializable {

    private Long id;

    @NotNull(message = "O campo nome é obrigatório e deve ser preenchido!")
    @NotEmpty(message = "O campo nome não pode ficar vazio!")
    private String nomePauta;

    @NotNull(message = "O campo descrição é obrigatório e deve ser preenchido!")
    @NotEmpty(message = "O campo descrição não pode ficar vazio!")
    private String descricaoPauta;

}
