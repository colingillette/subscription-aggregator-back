package com.colingillette.subscriptions.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document("entries")
@Getter
@Setter
public class Entry {

    @Id
    private String id;

    @TextIndexed
    private String name;

    private String description;
    private int length;
    private LocalDateTime releaseTimeStamp;
    private MediaType mediaType;
    private long views;
    private boolean favorite;

    @DBRef
    private List<Author> authors;

    @DBRef
    private Channel channel;

    @DBRef
    private Provider provider;

    public Entry() {
        super();
        this.id = UUID.randomUUID().toString();
        this.authors = new ArrayList<>();
        this.mediaType = MediaType.Other;
        this.favorite = false;
    }

    public Entry(String name, String description, int length, LocalDateTime releaseTimeStamp, MediaType type, long views, boolean favorite) {
        this();
        this.name = name;
        this.description = description;
        this.length = length;
        this.releaseTimeStamp = releaseTimeStamp;
        this.mediaType = type;
        this.views = views;
        this.favorite = favorite;
    }
}
