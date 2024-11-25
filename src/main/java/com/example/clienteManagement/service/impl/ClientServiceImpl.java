package com.example.clienteManagement.service.impl;

import com.example.clienteManagement.dto.Client;
import com.example.clienteManagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> getClients() {
        log.info("Se obtienen los clientes");
        return clients;
    }

    @Override
    public List<Client> getClient(String sharedKey) {
        log.info("Se obtiene cliente por sharedKey:{}",sharedKey);
        return clients.stream()
                .filter(client -> client.getSharedKey().equals(sharedKey))
                .collect(Collectors.toList());
    }

    @Override
    public Void saveClient(Client client) {
        log.info("Se guarda cliente con sharedKey: {}", client.getSharedKey());
        clients.add(client);
        return null;
    }
}
