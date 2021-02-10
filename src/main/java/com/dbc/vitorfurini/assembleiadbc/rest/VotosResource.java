package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import com.dbc.vitorfurini.assembleiadbc.service.VotosService;
import com.dbc.vitorfurini.assembleiadbc.vo.request.VotosRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.VotosResponseVO;
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
@RequestMapping("/v1/api/votos")
@CrossOrigin(origins = "*")
public class VotosResource {

    private final VotosService votoService;
    private final ModelMapper modelMapper;

    public VotosResource(VotosService votoService, ModelMapper modelMapper) {
        this.votoService = votoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<VotosResponseVO>> listar() {
        List<Votos> votos = votoService.listAll();
        List<VotosResponseVO> votosResponseVO = votos.stream()
                .map(voto -> modelMapper.map(voto, VotosResponseVO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(votosResponseVO);
    }

    @PostMapping
    public ResponseEntity<VotosRequestVO> salvarVoto(@Valid @RequestBody VotosRequestVO votosRequestVO) {
        Votos votos = modelMapper.map(votosRequestVO, Votos.class);
        Votos novosVotos = votoService.save(votos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(novosVotos, VotosRequestVO.class));
    }

}
