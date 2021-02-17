package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.repository.PautaRepository;
import com.dbc.vitorfurini.assembleiadbc.service.PautaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaServiceImpl implements PautaService {

    private final PautaRepository pautaRepository;

    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public List<Pauta> listAll() {
        return pautaRepository.findAll();
    }

    @Override
    public Pauta novaPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @Override
    public Optional<Pauta> findById(Long pauta) {
        return pautaRepository.findById(pauta);
    }
}
