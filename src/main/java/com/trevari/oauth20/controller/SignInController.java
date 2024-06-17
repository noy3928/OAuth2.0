package com.trevari.oauth20.controller;

import com.trevari.oauth20.dto.UserSignInRequest;
import com.trevari.oauth20.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SignInController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> signInUser(@RequestBody UserSignInRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            String jwt = jwtUtils.generateJwtToken(authentication);

            Map<String, String> response = new HashMap<>();
            response.put("token", jwt);

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
