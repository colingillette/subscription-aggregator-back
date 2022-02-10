package com.colingillette.subscriptions.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document("users")
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String email;

    @DBRef
    private List<Entry> queuedEntries;

    @DBRef
    private List<Entry> favoriteEntries;

    @DBRef
    private List<Channel> subscribedChannels;

    public User() {
        super();
        this.id = UUID.randomUUID().toString();
        this.queuedEntries = new ArrayList<>();
        this.favoriteEntries = new ArrayList<>();
        this.subscribedChannels = new ArrayList<>();
    }

    public User(String email) {
        this();
        this.email = email;
    }
}
