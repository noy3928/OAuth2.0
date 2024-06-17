package com.trevari.oauth20.service;

import com.trevari.oauth20.model.Client;
import com.trevari.oauth20.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(String redirectUri, String clientName) {
        Client client = new Client();
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        client.setRedirectUri(redirectUri);
        client.setClientName(clientName);
        return clientRepository.save(client);
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }
}
