package com.trevari.oauth20.controller;

import com.trevari.oauth20.dto.UserSignUpRequest;
import com.trevari.oauth20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpRequest request) {
        System.out.println("SignUpController: registerUser called with username: " + request.getUsername());
        userService.signup(request.getUsername(), request.getPassword(), request.getEmail());
        return ResponseEntity.ok("User sign up successfully");
    }
}