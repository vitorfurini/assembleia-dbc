package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.dto.PautaDto;
import com.dbc.vitorfurini.assembleiadbc.service.PautaService;
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
@RequestMapping("/v1/api/pautas")
@CrossOrigin(origins = "*")
public class PautaResource {

    private final PautaService pautaService;
    private final ModelMapper modelMapper;

    public PautaResource(PautaService pautaService, ModelMapper modelMapper) {
        this.pautaService = pautaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<PautaDto>> listarPautas() {
        List<Pauta> pautas = pautaService.listarAll();
        List<PautaDto> pautaDtos = pautas.stream().map(pauta -> modelMapper.map(pauta,
                PautaDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(pautaDtos);
    }

    @PostMapping
    public ResponseEntity<PautaDto> novaPauta(@Valid @RequestBody PautaDto pautaDto) {
        Pauta pauta = modelMapper.map(pautaDto, Pauta.class);
        Pauta novaPauta1 = pautaService.novaPauta(pauta);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(novaPauta1, PautaDto.class));
    }
}
