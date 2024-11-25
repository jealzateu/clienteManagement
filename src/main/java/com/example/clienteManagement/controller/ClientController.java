package com.example.clienteManagement.controller;

import com.example.clienteManagement.dto.Client;
import com.example.clienteManagement.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("client")
@RequiredArgsConstructor
@RestController
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @PostMapping()
    public ResponseEntity<Void> savaClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.saveClient(client));
    }

    @GetMapping("/searchBySharedKey")
    public ResponseEntity<List<Client>> getClientBySharedKey(@RequestParam String sharedKey) {
        return ResponseEntity.ok(clientService.getClient(sharedKey));
    }
}
