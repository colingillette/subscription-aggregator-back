package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
