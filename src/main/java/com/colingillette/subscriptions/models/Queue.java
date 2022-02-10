package com.colingillette.subscriptions.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document("queues")
@Getter
@Setter
public class Queue {

    @Id
    private String id;

    private LocalDateTime timeStamp;

    @DBRef
    private Entry entry;

    public Queue() {
        super();
        this.id = UUID.randomUUID().toString();
        this.timeStamp = LocalDateTime.now();
    }

    public Queue(Entry entry) {
        this();
        this.entry = entry;
    }

}
