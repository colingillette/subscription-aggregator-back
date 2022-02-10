package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {
}
