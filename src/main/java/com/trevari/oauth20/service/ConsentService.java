package com.trevari.oauth20.service;

import com.trevari.oauth20.model.Consent;
import com.trevari.oauth20.model.User;
import com.trevari.oauth20.model.Client;
import com.trevari.oauth20.repository.ConsentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsentService {

    @Autowired
    private ConsentRepository consentRepository;

    public Consent giveConsent(User user, Client client, boolean granted, String scope) {
        Optional<Consent> existingConsent = consentRepository.findByUserAndClient(user, client);
        Consent consent;
        if (existingConsent.isPresent()) {
            consent = existingConsent.get();
            consent.setGranted(granted);
            consent.setScope(scope);
        } else {
            consent = new Consent();
            consent.setUser(user);
            consent.setClient(client);
            consent.setGranted(granted);
            consent.setScope(scope);
        }
        return consentRepository.save(consent);
    }

    public boolean checkConsent(User user, Client client) {
        return consentRepository.findByUserAndClient(user, client)
                .map(Consent::isGranted)
                .orElse(false);
    }
}
