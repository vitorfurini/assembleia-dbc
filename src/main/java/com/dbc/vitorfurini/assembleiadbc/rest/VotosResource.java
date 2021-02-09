package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import com.dbc.vitorfurini.assembleiadbc.service.VotosService;
import com.dbc.vitorfurini.assembleiadbc.utils.JsonConverter;
import com.dbc.vitorfurini.assembleiadbc.vo.request.VotosRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.VotosResponseVO;
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
    private final JsonConverter jsonConverter;

    public VotosResource(VotosService votoService, JsonConverter jsonConverter) {
        this.votoService = votoService;
        this.jsonConverter = jsonConverter;
    }

    @GetMapping
    public ResponseEntity<List<VotosResponseVO>> listar() {
        List<Votos> votos = votoService.listAll();
        List<VotosResponseVO> votosResponseVO = votos.stream()
                .map(voto -> jsonConverter.convertObject(voto, VotosResponseVO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(votosResponseVO);
    }

    @PostMapping
    public ResponseEntity<VotosRequestVO> salvarVoto(@Valid @RequestBody VotosRequestVO votosRequestVO) {
        Votos votos = jsonConverter.convertObject(votosRequestVO, Votos.class);
        Votos novosVotos = votoService.save(votos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jsonConverter.convertObject(votosRequestVO, VotosRequestVO.class));
    }

}
