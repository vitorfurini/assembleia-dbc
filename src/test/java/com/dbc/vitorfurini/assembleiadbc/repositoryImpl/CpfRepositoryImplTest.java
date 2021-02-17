package com.dbc.vitorfurini.assembleiadbc.repositoryImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

public class CpfRepositoryImplTest {

    @Mock
    CpfRepositoryImpl cpfRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cpfRepository = new CpfRepositoryImpl(restTemplate);
    }

    @Test
    public void testWhenCpfIsValid() {
        String cpf = "85135127020";
        boolean isValid = cpfRepository.isValidCpf(cpf);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testWhenCpfIsInValid() {
        String cpf = "1234567";
        boolean isValid = cpfRepository.isValidCpf(cpf);
        Assert.assertFalse(isValid);
    }

}
