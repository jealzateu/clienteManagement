package com.example.clienteManagement.service;

import com.example.clienteManagement.dto.Client;
import com.example.clienteManagement.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
public class ClientServiceTest {

    @Mock
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        clientService = new ClientServiceImpl();
    }

    @Test
    void testGetClients_ReturnsEmptyListInitially() {
        // Act
        List<Client> result = clientService.getClients();

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    void testSaveClient_AddsClientSuccessfully() {
        // Arrange
        Client client = new Client();
        client.setSharedKey("123");
        client.setBusinessId("B001");
        client.setEmail("test@example.com");
        client.setPhone("123456789");
        client.setDateAdded("2024-11-24");

        // Act
        clientService.saveClient(client);
        List<Client> result = clientService.getClients();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getSharedKey()).isEqualTo("123");
    }

    @Test
    void testGetClient_FindsClientBySharedKey() {
        // Arrange
        Client client1 = new Client();
        client1.setSharedKey("123");
        client1.setBusinessId("B001");
        client1.setEmail("client1@example.com");
        client1.setPhone("123456789");
        client1.setDateAdded("2024-11-24");

        Client client2 = new Client();
        client2.setSharedKey("456");
        client2.setBusinessId("B002");
        client2.setEmail("client2@example.com");
        client2.setPhone("987654321");
        client2.setDateAdded("2024-11-24");

        clientService.saveClient(client1);
        clientService.saveClient(client2);

        // Act
        List<Client> result = clientService.getClient("123");

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getSharedKey()).isEqualTo("123");
    }

    @Test
    void testGetClient_ReturnsEmptyListIfNotFound() {
        // Arrange
        Client client = new Client();
        client.setSharedKey("123");
        client.setBusinessId("B001");
        client.setEmail("test@example.com");
        client.setPhone("123456789");
        client.setDateAdded("2024-11-24");

        clientService.saveClient(client);

        // Act
        List<Client> result = clientService.getClient("999");

        // Assert
        assertThat(result).isEmpty();
    }

}
