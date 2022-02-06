package com.colingillette.subscriptions.repository;

import com.colingillette.subscriptions.entity.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
