package com.eco.authservice.repository;

import com.eco.authservice.domain.AuthClientDetails;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthClientRepository extends MongoRepository<AuthClientDetails, String> {
    Optional<AuthClientDetails> findByClientId(String clientId);
}
