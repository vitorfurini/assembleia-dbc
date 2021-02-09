package com.dbc.vitorfurini.assembleiadbc;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.mock.Mocks;
import com.dbc.vitorfurini.assembleiadbc.repository.AssembleiaRepository;
import com.dbc.vitorfurini.assembleiadbc.service.AssembleiaService;
import com.dbc.vitorfurini.assembleiadbc.serviceImpl.AssembleiaServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AssembleiaServiceImplTest {

    @Mock
    AssembleiaServiceImpl assembleiaServiceImpl;
    @Mock
    AssembleiaRepository assembleiaRepository;
    @Mock
    AssembleiaService assembleiaService;
    @Mock
    Mocks mocks;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        assembleiaServiceImpl = new AssembleiaServiceImpl(assembleiaRepository);
        mocks = new Mocks();
    }


    @Test
    public void testWhenContextIsHappy() {
        Assembleia assembleiaExpected = mocks.getAssembleia();

        Mockito.when(assembleiaServiceImpl.novaAssembleia(assembleiaExpected)).thenReturn(assembleiaExpected);

       Assembleia result = assembleiaServiceImpl.novaAssembleia(assembleiaExpected);

        Assert.assertEquals(result, assembleiaExpected);

//        Mockito.verify(assembleiaRepository.save(assembleia))

    }
}
