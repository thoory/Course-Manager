package fr.utbm.lo54.tp.scheduler.service;

import com.mysql.cj.xdevapi.Client;
import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.repository.ClientDAO;
import org.intellij.lang.annotations.MagicConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @Mock
    private ClientDAO cLientDaoMock;

    @InjectMocks
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
    }
}