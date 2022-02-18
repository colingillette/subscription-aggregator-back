package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Channel;
import com.colingillette.subscriptions.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    ChannelRepository channelRepository;

    @GetMapping("/channels")
    public List<Channel> all() {
        return channelRepository.findAll();
    }

    @GetMapping("/channels/{id}")
    public Channel one(@PathVariable String id) {
        return channelRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @CrossOrigin
    @GetMapping("/channels/subscribed")
    public List<Channel> allSubscribed() {
        return channelRepository.findBySubscribedOrderByName(true);
    }

    @PostMapping("/channels")
    public Channel create(@RequestBody Channel channel) {
        return channelRepository.insert(channel);
    }

    @PutMapping("/channels/{id}")
    public Channel update(@PathVariable String id, @RequestBody Channel newChannel) {
        Channel channel = channelRepository.findById(id).orElseThrow(RuntimeException::new);

        channel.setName(newChannel.getName());
        channel.setDescription(newChannel.getDescription());
        channel.setUri(newChannel.getUri());
        channel.setSubscribed(newChannel.isSubscribed());
        channel.setProvider(newChannel.getProvider());

        return channelRepository.save(channel);
    }

    @DeleteMapping("/channels/{id}")
    public void delete(@PathVariable String id) {
        channelRepository.deleteById(id);
    }
}
