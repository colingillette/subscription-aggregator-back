package com.colingillette.subscriptions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of entries.
 * Examples: GameMakers Toolkit, Markiplier (the channel), The Escapist.
 */
@Entity
@Table(name = "CHANNEL")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Channel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Lob
    private Byte[] thumbnail;

    @ManyToMany(mappedBy = "channels")
    @JsonIgnore
    private List<Author> authors;

    @OneToMany(mappedBy = "channel")
    @JsonIgnore
    private List<Entry> entries;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToMany(mappedBy = "channels")
    @JsonIgnore
    private List<User> subscribedUsers;

    public Channel() {
        super();
        this.authors = new ArrayList<>();
        this.subscribedUsers = new ArrayList<>();
    }

    public Channel(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public boolean removeAuthor(Author author) {
        return this.authors.remove(author);
    }

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public boolean removeEntry(Entry entry) {
        return this.entries.remove(entry);
    }

    public void addSubscribedUser(User user) {
        this.subscribedUsers.add(user);
    }

    public boolean removeSubscribedUser(User user) {
        return this.subscribedUsers.remove(user);
    }
}
