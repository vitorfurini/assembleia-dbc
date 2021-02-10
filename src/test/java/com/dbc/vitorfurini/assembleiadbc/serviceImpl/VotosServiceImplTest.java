package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Votos;
import com.dbc.vitorfurini.assembleiadbc.mock.Mocks;
import com.dbc.vitorfurini.assembleiadbc.repository.VotosRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class VotosServiceImplTest {

    @Mock
    VotosServiceImpl votosServiceImpl;
    @Mock
    VotosRepository votosRepository;
    @Mock
    Mocks mocks;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        votosServiceImpl = new VotosServiceImpl(votosRepository);
        mocks = new Mocks();
    }

    @Test
    public void testListAll() {
        List<Votos> votosList = mocks.getListVotos();
        Mockito.when(votosRepository.findAll()).thenReturn(mocks.getListVotos());

        List<Votos> lista = votosServiceImpl.listAll();

        Assert.assertEquals(votosList, lista);
    }

    @Test
    public void testWhenContextIsHappy() {

        Votos votosExpected = mocks.getVotos();

        Mockito.when(votosServiceImpl.save(votosExpected)).thenReturn(votosExpected);

        Votos result = votosServiceImpl.save(votosExpected);

        Assert.assertEquals(result, votosExpected);

    }
}
