package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.service.AssociadoService;
import com.dbc.vitorfurini.assembleiadbc.utils.JsonConverter;
import com.dbc.vitorfurini.assembleiadbc.vo.request.AssociadoRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.AssociadoResposeVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/associados")
@CrossOrigin(origins = "*")
public class AssociadoResource {

    private final AssociadoService associadoService;
    private final JsonConverter jsonConverter;

    public AssociadoResource(AssociadoService associadoService, JsonConverter jsonConverter) {
        this.associadoService = associadoService;
        this.jsonConverter = jsonConverter;
    }

    @GetMapping
    public ResponseEntity<List<AssociadoResposeVO>> listAll() {
        List<Associado> associados = associadoService.listAll();
        List<AssociadoResposeVO> associadoResposeVO =
                associados.stream().map(associado -> jsonConverter.convertObject(associado,
                AssociadoResposeVO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(associadoResposeVO);
    }

    @GetMapping(path = {"/find/{cpf}"})
    public ResponseEntity<Associado> findByCpfAssociado(@PathVariable String cpf) {
        Associado associados = associadoService.findByCpf(cpf);
        return ResponseEntity.ok(associados);
    }

    @PostMapping
    public ResponseEntity<AssociadoRequestVO> cadastrar(@Valid @RequestBody AssociadoRequestVO associadoRequestVO) {
        Associado associado = jsonConverter.convertObject(associadoRequestVO, Associado.class);
        Associado novoAssociado = associadoService.novoAssociado(associado);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jsonConverter.convertObject(novoAssociado, AssociadoRequestVO.class));
    }

}
