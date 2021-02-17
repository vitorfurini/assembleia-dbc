package com.dbc.vitorfurini.assembleiadbc.validationImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.mock.Mocks;
import com.dbc.vitorfurini.assembleiadbc.repository.AssociadoRepository;
import com.dbc.vitorfurini.assembleiadbc.repositoryImpl.CpfRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static java.lang.Boolean.TRUE;

public class ValidationImplTest {

    private ValidationImpl validation;
    @Mock
    AssociadoRepository associadoRepository;
    @Mock
    CpfRepositoryImpl cpfRepository;
    @Mock
    Mocks mocks;

    private final RestTemplate restTemplate = new RestTemplate();


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validation = new ValidationImpl(cpfRepository, associadoRepository, restTemplate);
        mocks = new Mocks();
    }

    @Test
    public void testWhenContextIsHappy() {
        Associado associadoExpected = mocks.getAssociado();

        Mockito.when(cpfRepository.isValidCpf(associadoExpected.getCpfAssociado())).thenReturn(TRUE);

        validation.validaAssociado(associadoExpected);

        Assert.assertTrue("Associado válido!", TRUE);
    }

    @Test
    public void testWhenContextIsValidCpf() {
        Associado associadoExpected = mocks.getAssociado();
        Mockito.when(cpfRepository.isValidCpf(associadoExpected.getCpfAssociado())).thenReturn(TRUE);

        validation.validaCpf(associadoExpected.getCpfAssociado());

        Assert.assertTrue("CPF válido!", TRUE);
    }


}