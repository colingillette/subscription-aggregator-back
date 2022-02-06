package com.colingillette.subscriptions.repository;

import com.colingillette.subscriptions.entity.Channel;
import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
}
