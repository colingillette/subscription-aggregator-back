package com.colingillette.subscriptions.repository;

import com.colingillette.subscriptions.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
