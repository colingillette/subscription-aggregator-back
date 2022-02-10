package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Entry;
import com.colingillette.subscriptions.models.MediaType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntryRepository extends MongoRepository<Entry, String> {

    List<Entry> findByMediaType(MediaType type);
}
