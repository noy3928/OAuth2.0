package com.trevari.oauth20.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private String clientId;
    private String redirectUri;
    private String clientName;
    private String authorizationEndpoint;
    private String tokenEndpoint;
}
