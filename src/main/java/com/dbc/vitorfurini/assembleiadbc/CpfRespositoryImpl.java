package com.dbc.vitorfurini.assembleiadbc;

import com.dbc.vitorfurini.assembleiadbc.config.Config;
import com.dbc.vitorfurini.assembleiadbc.repository.CpfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
public class CpfRespositoryImpl implements CpfRepository {

    private static final Logger log = LoggerFactory.getLogger(CpfRespositoryImpl.class);
    private final RestTemplate restTemplate;


    public CpfRespositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean isValidCpf(String cpf) {

        try {
            log.info("Validadndo cpf do associado em API externa");
            restTemplate.getForObject(Config.URL.concat(cpf), Map.class);
            log.info("CPF validado com sucesso!");
            return true;
        } catch (HttpStatusCodeException exception) {
            log.info("CPF inválido!");
            return false;
        }

    }
}
