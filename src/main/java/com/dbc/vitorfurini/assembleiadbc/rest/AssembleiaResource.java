package com.dbc.vitorfurini.assembleiadbc.rest;


import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.dto.AssembleiaDto;
import com.dbc.vitorfurini.assembleiadbc.service.AssembleiaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/assembleias")
@CrossOrigin(origins = "*")
public class AssembleiaResource {

    private final AssembleiaService assembleiaService;
    private final ModelMapper modelMapper;

    public AssembleiaResource(AssembleiaService assembleiaService, ModelMapper modelMapper) {
        this.assembleiaService = assembleiaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AssembleiaDto>> listarAssembleias() {
        List<Assembleia> assembleias = assembleiaService.listAll();
//        List<Assembleia> assembleias1 = assembleiaService.findByIdPauta(pauta);
        List<AssembleiaDto> assembleiaDtos = assembleias.stream().map(assembleia -> modelMapper.map(assembleia,
                AssembleiaDto.class)).collect(Collectors.toList());

        return ResponseEntity.ok(assembleiaDtos);
    }

    @PostMapping
    public ResponseEntity<AssembleiaDto> cadastrar(@Valid @RequestBody AssembleiaDto assembleiaDto) {
        Assembleia assembleia = modelMapper.map(assembleiaDto, Assembleia.class);
        Assembleia novaAssembleia1 = assembleiaService.novaAssembleia(assembleia);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(novaAssembleia1, AssembleiaDto.class));
    }
}
