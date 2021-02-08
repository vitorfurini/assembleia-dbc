package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.dto.VotosDto;
import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbc.vitorfurini.assembleiadbc.service.VotosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/votos")
@CrossOrigin(origins = "*")
public class VotosResource {

    private static final Logger log = LoggerFactory.getLogger(VotosResource.class);

    private final VotosService votoService;
    private final ModelMapper modelMapper;

    public VotosResource(VotosService votoService, ModelMapper modelMapper) {
        this.votoService = votoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<VotosDto>> listar() {
        log.info("Requisição Rest para listar os votos computados");
        List<Votos> votos = votoService.listAll();
        List<VotosDto> votosDto = votos.stream()
                .map(voto -> modelMapper.map(voto, VotosDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(votosDto);
    }

}
