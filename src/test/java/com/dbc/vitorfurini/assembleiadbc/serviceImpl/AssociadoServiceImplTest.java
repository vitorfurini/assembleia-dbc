package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Associado;
import com.dbc.vitorfurini.assembleiadbc.mock.Mocks;
import com.dbc.vitorfurini.assembleiadbc.repository.AssociadoRepository;
import com.dbc.vitorfurini.assembleiadbc.validation.Validation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class AssociadoServiceImplTest {

    @Mock
    AssociadoServiceImpl associadoServiceImpl;
    @Mock
    AssociadoRepository associadoRespository;
    @Mock
    Validation validation;
    @Mock
    Mocks mocks;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        associadoServiceImpl = new AssociadoServiceImpl(associadoRespository, validation);
        mocks = new Mocks();
    }

    @Test
    public void testListAll() {
        List<Associado> associadoList = mocks.getListAssociados();
        Mockito.when(associadoRespository.findAll()).thenReturn(mocks.getListAssociados());

        List<Associado> lista = associadoServiceImpl.listAll();

        Assert.assertEquals(associadoList, lista);
    }

    @Test
    public void testWhenContextIsHappy() {
        Associado associadoExpected = mocks.getAssociado();

        Mockito.when(associadoServiceImpl.novoAssociado(associadoExpected)).thenReturn(associadoExpected);

        Associado result = associadoServiceImpl.novoAssociado(associadoExpected);

        Assert.assertEquals(result, associadoExpected);

    }
}