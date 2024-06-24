package com.devsu.customerservice.infrastructure.repository.client;

import com.devsu.customerservice.domain.model.Client;
import com.devsu.customerservice.domain.model.Gender;
import com.devsu.customerservice.infrastructure.communication.AsyncRestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static  org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ClientRepositoryImpTest {

    private SpringDataClientRepository springDataClientRepository;

    private AsyncRestService asyncRestService;

    private ClientRepositoryImp clientRepositoryImp;

    private ClientEntity clientEntity;
    private Client client;

    @BeforeEach
    public void setUp() {
        springDataClientRepository = Mockito.mock(SpringDataClientRepository.class);
        asyncRestService = Mockito.mock(AsyncRestService.class);
        clientRepositoryImp = new ClientRepositoryImp(springDataClientRepository,asyncRestService);

        clientEntity = new ClientEntity();
        clientEntity.setId(1L);
        clientEntity.setName("Felipe Gonzalez");
        clientEntity.setGender(Gender.MALE);
        clientEntity.setAge(30);
        clientEntity.setIdentification("ID123456");
        clientEntity.setAddress("123 Main St");
        clientEntity.setPhone("555-1234");
        clientEntity.setPassword("password");
        clientEntity.setStatus(true);
        clientEntity.setClientId("FG123");

        client = new Client();
        client.setId(1L);
        client.setName("Felipe Gonzalez");
        client.addGender("Hombre");
        client.setAge(30);
        client.setIdentification("ID123456");
        client.setAddress("123 Main St");
        client.setPhone("555-1234");
        client.setPassword("password");
        client.setStatus(true);
        client.addClientId("FG123");
    }

    @Test
    public void testFindAll() {
        when(springDataClientRepository.findAll()).thenReturn(Collections.singletonList(clientEntity));

        List<Client> clients = clientRepositoryImp.findAll();
        assertNotNull(clients);
        assertEquals(1, clients.size());
        assertEquals(client.getName(), clients.get(0).getName());

        verify(springDataClientRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(springDataClientRepository.findById(1L)).thenReturn(Optional.of(clientEntity));

        Optional<Client> foundClient = clientRepositoryImp.findById(1L);
        assertTrue(foundClient.isPresent());
        assertEquals(client.getName(), foundClient.get().getName());

        verify(springDataClientRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindByClientId() {
        when(springDataClientRepository.findByClientId("JD123")).thenReturn(Optional.of(clientEntity));

        Optional<Client> foundClient = clientRepositoryImp.findByClientId("JD123");
        assertTrue(foundClient.isPresent());
        assertEquals(client.getName(), foundClient.get().getName());

        verify(springDataClientRepository, times(1)).findByClientId("JD123");
    }

    @Test
    public void testSave() {
        when(springDataClientRepository.save(any(ClientEntity.class))).thenReturn(clientEntity);

        Client savedClient = clientRepositoryImp.save(client);
        assertNotNull(savedClient);
        assertEquals(client.getName(), savedClient.getName());

        verify(springDataClientRepository, times(1)).save(any(ClientEntity.class));
    }

    @Test
    public void testDeleteByClientId() {
        doNothing().when(springDataClientRepository).deleteByClientId("JD123");
        doNothing().when(asyncRestService).deleteSyncData("cuentas/cliente/JD123");

        clientRepositoryImp.deleteByClientId("JD123");

        verify(springDataClientRepository, times(1)).deleteByClientId("JD123");
        verify(asyncRestService, times(1)).deleteSyncData("cuentas/cliente/JD123");

        verify(springDataClientRepository, times(1)).deleteByClientId("JD123");
        verify(asyncRestService, times(1)).deleteSyncData("cuentas/cliente/JD123");
    }

}