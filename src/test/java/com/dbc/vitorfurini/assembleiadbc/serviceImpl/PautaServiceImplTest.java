package com.dbc.vitorfurini.assembleiadbc.serviceImpl;

import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.mock.Mocks;
import com.dbc.vitorfurini.assembleiadbc.repository.PautaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class PautaServiceImplTest {

    @Mock
    PautaServiceImpl pautaServiceImpl;
    @Mock
    PautaRepository pautaRepository;
    @Mock
    Mocks mocks;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pautaServiceImpl = new PautaServiceImpl(pautaRepository);
        mocks = new Mocks();
    }

    @Test
    public void testListAll() {
        List<Pauta> pautaList = mocks.getListPautas();
        Mockito.when(pautaRepository.findAll()).thenReturn(mocks.getListPautas());

        List<Pauta> lista = pautaServiceImpl.listAll();

        Assert.assertEquals(pautaList, lista);
    }

    @Test
    public void testWhenContextIsHappy() {

        Pauta pautaExpected = mocks.getPauta();

        Mockito.when(pautaServiceImpl.novaPauta(pautaExpected)).thenReturn(pautaExpected);

        Pauta result = pautaServiceImpl.novaPauta(pautaExpected);

        Assert.assertEquals(result, pautaExpected);

    }
}