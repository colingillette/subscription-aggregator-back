package com.colingillette.subscriptions.repositories;

import com.colingillette.subscriptions.models.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChannelRepository extends MongoRepository<Channel, String> {

    List<Channel> findBySubscribedOrderByName(boolean subscribed);
}
