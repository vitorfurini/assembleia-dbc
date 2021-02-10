package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.repository.AssociadoRepository;
import com.dbc.vitorfurini.assembleiadbc.service.AssociadoService;
import com.dbc.vitorfurini.assembleiadbc.validation.Validation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    private final AssociadoRepository associadoRespository;
    private final Validation validation;

    public AssociadoServiceImpl(AssociadoRepository associadoRespository, Validation validation) {
        this.associadoRespository = associadoRespository;
        this.validation = validation;
    }

    @Override
    public List<Associado> listAll() {
        return associadoRespository.findAll();
    }

    @Override
    public Associado findByCpf(String cpfAssociado) {
        return associadoRespository.findByCpfAssociado(cpfAssociado);
    }

    @Override
    public Associado novoAssociado(Associado associado) {
        validation.validaAssociado(associado);
        return associadoRespository.save(associado);
    }
}
