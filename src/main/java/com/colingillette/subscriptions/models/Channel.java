package com.colingillette.subscriptions.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("channels")
@Getter
@Setter
public class Channel {

    @Id
    private String id;

    @TextIndexed
    private String name;

    private String description;
    private String uri;
    private boolean subscribed;

    public Channel() {
        super();
        this.id = UUID.randomUUID().toString();
    }

    public Channel(String name, String description, String uri) {
        this();
        this.name = name;
        this.description = description;
        this.uri = uri;
    }
}
