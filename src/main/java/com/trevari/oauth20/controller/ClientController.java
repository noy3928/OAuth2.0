package com.trevari.oauth20.controller;

import com.trevari.oauth20.model.Client;
import com.trevari.oauth20.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<?> registerClient(@RequestParam String redirectUri, @RequestParam String clientName) {
        Client client = clientService.registerClient(redirectUri, clientName);
        return ResponseEntity.ok(client);
    }
}
