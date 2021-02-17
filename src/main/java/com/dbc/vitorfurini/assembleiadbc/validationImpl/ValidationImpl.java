package com.dbc.vitorfurini.assembleiadbc.validationImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.exception.AssembleiaException;
import com.dbc.vitorfurini.assembleiadbc.exception.ValidationException;
import com.dbc.vitorfurini.assembleiadbc.repository.AssociadoRepository;
import com.dbc.vitorfurini.assembleiadbc.repository.CpfRepository;
import com.dbc.vitorfurini.assembleiadbc.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ValidationImpl implements Validation {

    private CpfRepository cpfRepository;
    private AssociadoRepository associadoRespository;
    private final RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(ValidationImpl.class);


    public ValidationImpl(CpfRepository cpfRepository, AssociadoRepository associadoRespository, RestTemplate restTemplate) {
        this.cpfRepository = cpfRepository;
        this.associadoRespository = associadoRespository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void validaAssociado(Associado associado) {

        boolean isCpfValido = cpfRepository.isValidCpf(associado.getCpfAssociado());

        if (!isCpfValido) {
            throw new AssembleiaException("CPF informado é inválido");
        }

        Optional<Associado> verificaAssociado = Optional.ofNullable(associadoRespository.findByCpfAssociado(associado.getCpfAssociado()));

        if (verificaAssociado.isPresent()) {
            throw new AssembleiaException("O associado já está cadastrado");
        }

    }

    @Override
    public void validaCpf(String cpf) {
        if (cpfRepository.isValidCpf(cpf)) {
            log.info("O CPF informado é válido");
        } else {
            throw new ValidationException("O CPF informado é inválido");
        }
    }
}
