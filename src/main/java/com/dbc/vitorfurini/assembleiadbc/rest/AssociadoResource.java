package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.service.AssociadoService;
import com.dbc.vitorfurini.assembleiadbc.vo.request.AssociadoRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.AssociadoResposeVO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(AssociadoResource.class);

    private final AssociadoService associadoService;
    private final ModelMapper modelMapper;

    public AssociadoResource(AssociadoService associadoService, ModelMapper modelMapper) {
        this.associadoService = associadoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AssociadoResposeVO>> listAll() {
        log.info("Requisição para listar todos os associados cadastrados");
        List<Associado> associados = associadoService.listAll();
        List<AssociadoResposeVO> associadoResposeVO =
                associados.stream().map(associado -> modelMapper.map(associado,
                AssociadoResposeVO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(associadoResposeVO);
    }

    @GetMapping(path = {"/find/{cpf}"})
    public ResponseEntity<Associado> findByCpfAssociado(@PathVariable String cpf) {
        log.info("Requisição para buscar associado por cpf");
        Associado associados = associadoService.findByCpf(cpf);
        return ResponseEntity.ok(associados);
    }

    @PostMapping
    public ResponseEntity<AssociadoRequestVO> cadastrar(@Valid @RequestBody AssociadoRequestVO associadoRequestVO) {
        log.info("Requisição para cadastrar um novo associado");
        Associado associado = modelMapper.map(associadoRequestVO, Associado.class);
        Associado novoAssociado = associadoService.novoAssociado(associado);
        log.info("Associado cadastrado com sucesso! {}", associadoRequestVO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(novoAssociado, AssociadoRequestVO.class));
    }

}
