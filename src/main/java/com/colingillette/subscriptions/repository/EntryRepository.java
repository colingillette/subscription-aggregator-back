package com.colingillette.subscriptions.repository;

import com.colingillette.subscriptions.entity.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {
}
