package com.colingillette.subscriptions.repository;

import com.colingillette.subscriptions.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
