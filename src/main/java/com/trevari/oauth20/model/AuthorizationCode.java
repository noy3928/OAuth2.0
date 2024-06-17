package com.trevari.oauth20.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorizationCode {
    private final String code;
    private final User user;
    private final Client client;
}
