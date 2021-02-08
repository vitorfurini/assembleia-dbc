package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.dto.AssociadoDto;
import com.dbc.vitorfurini.assembleiadbc.service.AssociadoService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public AssociadoResource(AssociadoService associadoService, ModelMapper modelMapper) {
        this.associadoService = associadoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<AssociadoDto>> listAll() {
        List<Associado> associados = associadoService.listAll();
        List<AssociadoDto> associadoDtos = associados.stream().map(associado -> modelMapper.map(associado,
                AssociadoDto.class)).collect(Collectors.toList());

        return ResponseEntity.ok(associadoDtos);
    }

    @GetMapping(path = {"/find/{cpf}"})
    public ResponseEntity<Associado> findByCpf(@PathVariable String cpf) {
        Associado associados = associadoService.findByCpf(cpf);
        return ResponseEntity.ok(associados);
    }

    @PostMapping
    public ResponseEntity<AssociadoDto> cadastrar(@Valid @RequestBody AssociadoDto associadoDto) {
        Associado associado = modelMapper.map(associadoDto, Associado.class);
        Associado associado1 = associadoService.novoAssociado(associado);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(associado1, AssociadoDto.class));
    }

}
