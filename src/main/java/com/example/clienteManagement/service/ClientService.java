package com.example.clienteManagement.service;

import com.example.clienteManagement.dto.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();

    List<Client> getClient(String sharedKey);

    Void saveClient(Client client);
}
