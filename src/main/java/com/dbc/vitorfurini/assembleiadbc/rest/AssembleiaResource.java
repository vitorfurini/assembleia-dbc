package com.dbc.vitorfurini.assembleiadbc.rest;


import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.service.AssembleiaService;
import com.dbc.vitorfurini.assembleiadbc.vo.request.AssembleiaRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.AssembleiaResponseVO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/assembleias")
@CrossOrigin(origins = "*")
public class AssembleiaResource {

    private static final Logger log = LoggerFactory.getLogger(AssembleiaResource.class);

    private final AssembleiaService assembleiaService;
    private final ModelMapper modelMapper;

    public AssembleiaResource(AssembleiaService assembleiaService, ModelMapper modelMapper) {
        this.assembleiaService = assembleiaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AssembleiaResponseVO>> listarAssembleias() {
        log.info("Requisição para listar todas as assembleias");
        List<Assembleia> assembleias = assembleiaService.listAll();
        List<AssembleiaResponseVO> assembleiaResponse =
                assembleias.stream().map(assembleia -> modelMapper.map(assembleia,
                AssembleiaResponseVO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(assembleiaResponse);
    }

    @PostMapping
    public ResponseEntity<AssembleiaRequestVO> cadastrar(@Valid @RequestBody AssembleiaRequestVO assembleiaRequestVO) {
        log.info("Requisição para salvar uma nova assembleia");
        Assembleia assembleia = modelMapper.map(assembleiaRequestVO, Assembleia.class);
        assembleia.setDataCriacao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        Assembleia novaAssembleia1 = assembleiaService.novaAssembleia(assembleia);
        log.info("Assembleia cadastrada com sucesso {}", assembleiaRequestVO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(novaAssembleia1, AssembleiaRequestVO.class));
    }
}
