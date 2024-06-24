package com.devsu.customerservice.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientTest {

    @InjectMocks
    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client();
    }

    @Test
    public void testGenerateClientId() {
        // Act
        client.generateClientId();
        // Assert
        assertNotNull(client.getClientId());
        assertEquals(5, client.getClientId().length());
    }

    @Test
    public void testGetClientIdWhenClientIdIsNull() {
        // Act
        String actualClientId = client.getClientId();
        // Assert
        assertNull(actualClientId);
    }

    @Test
    public void testGetClientIdWhenClientIdIsNotNull() {
        // Arrange
        String expectedClientId = "65432";
        client.addClientId(expectedClientId);
        // Act
        String actualClientId = client.getClientId();
        // Assert
        assertEquals(expectedClientId, actualClientId);
    }

}