package com.dbc.vitorfurini.assembleiadbc.repositoryImpl;

import com.dbc.vitorfurini.assembleiadbc.config.Config;
import com.dbc.vitorfurini.assembleiadbc.repository.CpfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.ResourceBundle;

@Repository
public class CpfRepositoryImpl implements CpfRepository {

    private static final Logger log = LoggerFactory.getLogger(CpfRepositoryImpl.class);
    private final RestTemplate restTemplate;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    public CpfRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean isValidCpf(String cpf) {

        try {
            log.info(resourceBundle.getString("msg.cpf.validando"), cpf);
            restTemplate.getForObject(Config.URL.concat(cpf), Map.class);
            log.info(resourceBundle.getString("msg.cpf.valido"), cpf);
            return true;
        } catch (HttpStatusCodeException exception) {
            if (exception.getStatusCode().is5xxServerError()) {
                log.info(resourceBundle.getString("msg.erro.timeOut"));
            } else {
                log.info(resourceBundle.getString("msg.cpf.invalido"), cpf);
            }
            return false;
        }
    }
}
