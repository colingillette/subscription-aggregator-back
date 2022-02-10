package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String> {
}
