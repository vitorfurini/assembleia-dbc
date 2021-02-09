package com.dbc.vitorfurini.assembleiadbc.rest;


import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.service.AssembleiaService;
import com.dbc.vitorfurini.assembleiadbc.utils.JsonConverter;
import com.dbc.vitorfurini.assembleiadbc.vo.request.AssembleiaRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.AssembleiaResponseVO;
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

    private final AssembleiaService assembleiaService;
    private final JsonConverter jsonConverter;

    public AssembleiaResource(AssembleiaService assembleiaService, JsonConverter jsonConverter) {
        this.assembleiaService = assembleiaService;
        this.jsonConverter = jsonConverter;
    }

    @GetMapping
    public ResponseEntity<List<AssembleiaResponseVO>> listarAssembleias() {
        List<Assembleia> assembleias = assembleiaService.listAll();
        List<AssembleiaResponseVO> assembleiaResponse =
                assembleias.stream().map(assembleia -> jsonConverter.convertObject(assembleia,
                AssembleiaResponseVO.class)).collect(Collectors.toList());

        return ResponseEntity.ok(assembleiaResponse);
    }

    @PostMapping
    public ResponseEntity<AssembleiaRequestVO> cadastrar(@Valid @RequestBody AssembleiaRequestVO assembleiaRequestVO) {
        Assembleia assembleia = jsonConverter.convertObject(assembleiaRequestVO, Assembleia.class);
        assembleia.setDataCriacao(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        Assembleia novaAssembleia1 = assembleiaService.novaAssembleia(assembleia);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jsonConverter.convertObject(novaAssembleia1, AssembleiaRequestVO.class));
    }
}
