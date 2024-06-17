package com.trevari.oauth20.controller;

import com.trevari.oauth20.dto.ClientRequest;
import com.trevari.oauth20.dto.ClientResponse;
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
    public ResponseEntity<?> registerClient(@RequestBody ClientRequest clientRequest) {
        Client client = clientService.registerClient(clientRequest.getRedirectUri(), clientRequest.getClientName());
        ClientResponse clientResponse = new ClientResponse(
                client.getClientId(),
                client.getRedirectUri(),
                client.getClientName(),
                "https://auth-server.com/oauth/authorize", // 인증 엔드포인트
                "https://auth-server.com/oauth/token" // 토큰 엔드포인트
        );
        return ResponseEntity.ok(clientResponse);
    }
}
