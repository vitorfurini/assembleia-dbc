package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.repository.AssociadoRespository;
import com.dbc.vitorfurini.assembleiadbc.service.AssociadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    private AssociadoRespository associadoRespository;

    public AssociadoServiceImpl(AssociadoRespository associadoRespository) {
        this.associadoRespository = associadoRespository;
    }

    @Override
    public List<Associado> listAll() {
        return associadoRespository.findAll();
    }

    @Override
    public Associado findByCpf(String cpf) {
        return associadoRespository.findByCpf(cpf);
    }

    @Override
    public Associado novoAssociado(Associado associado) {
        return associadoRespository.save(associado);
    }
}
