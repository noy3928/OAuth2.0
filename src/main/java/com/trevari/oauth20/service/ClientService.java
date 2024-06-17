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

    public Client registerClient(String redirectUri) {
        Client client = new Client();
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(BCrypt.hashpw(UUID.randomUUID().toString(), BCrypt.gensalt()));
        client.setRedirectUri(redirectUri);
        return clientRepository.save(client);
    }
}
