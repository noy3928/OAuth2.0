package com.trevari.oauth20.repository;

import com.trevari.oauth20.model.Consent;
import com.trevari.oauth20.model.User;
import com.trevari.oauth20.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsentRepository extends JpaRepository<Consent, Long> {
    Optional<Consent> findByUserAndClient(User user, Client client);
}
