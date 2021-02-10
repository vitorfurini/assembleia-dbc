package com.dbc.vitorfurini.assembleiadbc;

import com.dbc.vitorfurini.assembleiadbc.config.Config;
import com.dbc.vitorfurini.assembleiadbc.repository.CpfRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Repository
public class CpfRespositoryImpl implements CpfRepository {

    private final RestTemplate restTemplate;

    public CpfRespositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean isValidCpf(String cpf) {

        try {
            restTemplate.getForObject(Config.URL.concat(cpf), Map.class);
            return true;
        } catch (HttpStatusCodeException exception) {
            return false;
        }

    }
}
