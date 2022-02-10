package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
