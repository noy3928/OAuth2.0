package com.trevari.oauth20.service;

import com.trevari.oauth20.model.AuthorizationCode;
import com.trevari.oauth20.model.Client;
import com.trevari.oauth20.model.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthorizationService {

    private final Map<String, AuthorizationCode> authorizationCodeStore = new ConcurrentHashMap<>();

    public String createAuthorizationCode(User user, Client client) {
        String code = UUID.randomUUID().toString();
        AuthorizationCode authorizationCode = new AuthorizationCode(code, user, client);
        authorizationCodeStore.put(code, authorizationCode);
        return code;
    }

    public AuthorizationCode getAuthorizationCode(String code) {
        return authorizationCodeStore.get(code);
    }

    public void removeAuthorizationCode(String code) {
        authorizationCodeStore.remove(code);
    }
}
