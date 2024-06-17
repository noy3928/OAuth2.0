package com.trevari.oauth20.controller;

import com.trevari.oauth20.model.Client;
import com.trevari.oauth20.model.User;
import com.trevari.oauth20.service.AuthorizationService;
import com.trevari.oauth20.service.ClientService;
import com.trevari.oauth20.service.ConsentService;
import com.trevari.oauth20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConsentController {

    @Autowired
    private ConsentService consentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/consent")
    public ResponseEntity<String> giveConsent(@RequestParam Long userId, @RequestParam Long clientId, @RequestParam boolean granted, @RequestParam String scope) {
        User user = userService.getUserById(userId);
        Client client = clientService.getClientById(clientId);
        if (user == null || client == null) {
            return ResponseEntity.status(404).body("User or Client not found");
        }

        consentService.giveConsent(user, client, granted, scope);

        if (granted) {
            String authorizationCode = authorizationService.createAuthorizationCode(user, client);
            String redirectUri = client.getRedirectUri() + "?code=" + authorizationCode;
            return ResponseEntity.status(302).header("Location", redirectUri).body("Redirecting to: " + redirectUri);
        } else {
            return ResponseEntity.ok("Consent denied");
        }
    }
}
