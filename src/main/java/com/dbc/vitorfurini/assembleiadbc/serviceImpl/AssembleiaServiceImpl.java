package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.repository.AssembleiaRepository;
import com.dbc.vitorfurini.assembleiadbc.service.AssembleiaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssembleiaServiceImpl implements AssembleiaService {

    private AssembleiaRepository assembleiaRepository;

    public AssembleiaServiceImpl(AssembleiaRepository assembleiaRepository) {
        this.assembleiaRepository = assembleiaRepository;
    }

    @Override
    public List<Assembleia> listAll() {
        return assembleiaRepository.findAll();
    }

    @Override
    public Assembleia novaAssembleia(Assembleia assembleia) {
        return assembleiaRepository.save(assembleia);
    }

    @Override
    public Optional<Assembleia> findByIdPauta(Pauta pauta) {
        return assembleiaRepository.findById(pauta.getId());
    }
}
