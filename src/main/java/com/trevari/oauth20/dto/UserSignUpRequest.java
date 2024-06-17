package com.trevari.oauth20.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequest {
    private String username;
    private String password;
    private String email; 
}
