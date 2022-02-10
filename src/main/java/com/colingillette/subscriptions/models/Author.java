package com.colingillette.subscriptions.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("authors")
@Getter
@Setter
public class Author {

    @Id
    private String id;

    private String name;
    private String bio;

    public Author() {
        super();
        this.id = UUID.randomUUID().toString();
    }

    public Author(String name, String bio) {
        this();
        this.name = name;
        this.bio = bio;
    }
}
