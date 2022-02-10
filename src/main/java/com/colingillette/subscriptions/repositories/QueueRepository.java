package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Queue;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QueueRepository extends MongoRepository<Queue, String> {

    List<Queue> findAllByOrderByTimeStampDesc();
}
