package com.dbc.vitorfurini.assembleiadbc;

import com.dbc.vitorfurini.assembleiadbc.domain.Assembleia;
import com.dbc.vitorfurini.assembleiadbc.domain.Pauta;
import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import com.dbc.vitorfurini.assembleiadbc.repository.AssembleiaRepository;
import com.dbc.vitorfurini.assembleiadbc.serviceImpl.AssembleiaServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public class AssembleiaServiceImplTest {

    AssembleiaServiceImpl assembleiaServiceImpl;
    @Mock
    AssembleiaRepository assembleiaRepository;


    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        assembleiaServiceImpl = new AssembleiaServiceImpl(assembleiaRepository);
    }


    @Test
    @Ignore
    public void testWhenContextIsHappy() {
        Assembleia assembleia = new Assembleia();
        Pauta pauta = new Pauta();

        assembleia.setName("Assembleia da geral do grêmio");
        assembleia.setData(LocalDateTime.now());
        assembleia.setDescricao("Assembleia para discutir se devemos permitir a volta do R10");
        assembleia.setDuracao(2L);
        assembleia.setPauta(pauta);
        assembleia.setStatusAssembleia(StatusAssembleia.ABERTA);

        Mockito.when(assembleiaServiceImpl.novaAssembleia(any())).thenReturn(assembleia);

        Assembleia a = assembleiaServiceImpl.novaAssembleia(assembleia);

        Mockito.verify(assembleiaServiceImpl, times(1)).novaAssembleia(any());
    }
}
