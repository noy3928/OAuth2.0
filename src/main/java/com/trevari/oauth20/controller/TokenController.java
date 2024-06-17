package com.trevari.oauth20.controller;

import com.trevari.oauth20.model.AuthorizationCode;
import com.trevari.oauth20.security.jwt.JwtUtils;
import com.trevari.oauth20.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TokenController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String code) {
        AuthorizationCode authorizationCode = authorizationService.getAuthorizationCode(code);
        if (authorizationCode == null) {
            return ResponseEntity.status(400).body("Invalid authorization code");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String jwt = jwtUtils.generateJwtToken(authentication);

        authorizationService.removeAuthorizationCode(code);

        return ResponseEntity.ok(jwt);
    }
}
