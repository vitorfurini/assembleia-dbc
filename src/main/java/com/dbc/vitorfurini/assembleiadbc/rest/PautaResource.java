package com.dbc.vitorfurini.assembleiadbc.rest;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.service.PautaService;
import com.dbc.vitorfurini.assembleiadbc.vo.request.PautaRequestVO;
import com.dbc.vitorfurini.assembleiadbc.vo.response.PautaResponseVO;
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

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/api/pautas")
@CrossOrigin(origins = "*")
public class PautaResource {

    private static final Logger log = LoggerFactory.getLogger(PautaResource.class);

    private final PautaService pautaService;
    private final ModelMapper modelMapper;

    public PautaResource(PautaService pautaService, ModelMapper modelMapper) {
        this.pautaService = pautaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<PautaResponseVO>> listarPautas() {
        log.info("Requisição para listar todas as pautas cadastradas");
        List<Pauta> pautas = pautaService.listAll();
        List<PautaResponseVO> pautaResponseVO = pautas.stream().map(pauta -> modelMapper.map(pauta,
                PautaResponseVO.class)).collect(Collectors.toList());
        return ResponseEntity.ok(pautaResponseVO);
    }

    @PostMapping
    public ResponseEntity<PautaRequestVO> novaPauta(@Valid @RequestBody PautaRequestVO pautaRequestVO) {
        log.info("Requisição para cadastrar uma nova pauta");
        Pauta pauta = modelMapper.map(pautaRequestVO, Pauta.class);
        Pauta novaPauta1 = pautaService.novaPauta(pauta);
        log.info("Pauta cadastrada com sucesso {}", pautaRequestVO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modelMapper.map(novaPauta1, PautaRequestVO.class));
    }
}
