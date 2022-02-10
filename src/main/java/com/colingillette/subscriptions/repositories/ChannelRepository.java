package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel, String> {
}
