package com.colingillette.subscriptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of the application.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;

    @ManyToMany
    private List<Entry> queuedEntries;

    @ManyToMany
    private List<Entry> favoriteEntries;

    @ManyToMany
    private List<Channel> channels;

    @ManyToMany
    private List<Provider> providers;

    public User() {
        super();
        this.queuedEntries = new ArrayList<>();
        this.favoriteEntries = new ArrayList<>();
        this.channels = new ArrayList<>();
        this.providers = new ArrayList<>();
    }

    public User(String email) {
        this();
        this.email = email;
    }

    public void addQueuedEntry(Entry entry) {
        this.queuedEntries.add(entry);
    }

    public boolean removeQueuedEntry(Entry entry) {
        return this.queuedEntries.remove(entry);
    }

    public void addFavoriteEntry(Entry entry) {
        this.favoriteEntries.add(entry);
    }

    public boolean removeFavoriteEntry(Entry entry) {
        return this.favoriteEntries.remove(entry);
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
