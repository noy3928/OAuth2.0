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
        userService.signup(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User sign up successfully");
    }
}