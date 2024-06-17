package com.trevari.oauth20.controller;

import com.trevari.oauth20.model.AuthorizationCode;
import com.trevari.oauth20.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TokenController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String code) {
        AuthorizationCode authorizationCode = authorizationService.getAuthorizationCode(code);
        if (authorizationCode == null) {
            return ResponseEntity.status(400).body("Invalid authorization code");
        }

        String accessToken = UUID.randomUUID().toString();

        authorizationService.removeAuthorizationCode(code);

        return ResponseEntity.ok(accessToken);
    }
}
