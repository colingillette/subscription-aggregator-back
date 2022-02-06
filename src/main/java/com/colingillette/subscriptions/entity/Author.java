package com.colingillette.subscriptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a real person who is a contributor/creator for an entry or channel.
 * Examples: Markiplier, Yahtzee, Michael Babaro.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDateTime lastEntryRelease;
    @Lob
    private Byte[] thumbnail;

    @ManyToMany
    private List<Entry> entries;

    @ManyToMany
    private List<Channel> channels;

    @ManyToMany
    private List<Provider> providers;

    public Author() {
        super();
        this.entries = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.providers = new ArrayList<>();
    }

    public Author(String name) {
        this();
        this.name = name;
    }

    public Author(String name, String description, LocalDateTime timeStamp) {
        this();
        this.name = name;
        this.description = description;
        this.lastEntryRelease = timeStamp;
    }

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public boolean removeEntry(Entry entry) {
        return this.entries.remove(entry);
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public boolean removeChannel(Channel channel) {
        return this.channels.remove(channel);
    }

    public void addProvider(Provider provider) {
        this.providers.add(provider);
    }

    public boolean removeProvider(Provider provider) {
        return this.providers.remove(provider);
    }
}
