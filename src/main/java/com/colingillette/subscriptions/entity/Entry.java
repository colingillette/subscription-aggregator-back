package com.colingillette.subscriptions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * An entry is a specific release item. A podcast episode, YouTube video, etc.
 */
@Entity
@Table(name = "ENTRY")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Entry {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int length;
    private LocalDateTime releaseTimeStamp;
    @Lob
    private Byte[] thumbnail;

    @ManyToOne
    @JoinColumn(name = "entry_id")
    private Channel channel;

    @ManyToMany
    @JoinTable(
            name = "entry_author",
            joinColumns = @JoinColumn(name = "entry_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToMany(mappedBy = "queuedEntries")
    @JsonIgnore
    private List<User> queuedUsers;

    @ManyToMany(mappedBy = "favoriteEntries")
    @JsonIgnore
    private List<User> favoriteUsers;

    public Entry() {
        super();
        this.authors = new ArrayList<>();
        this.queuedUsers = new ArrayList<>();
        this.favoriteUsers = new ArrayList<>();
    }

    public Entry(String name, String description, int length, LocalDateTime timeStamp) {
        this();
        this.name = name;
        this.description = description;
        this.length = length;
        this.releaseTimeStamp = timeStamp;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public boolean removeAuthor(Author author) {
        return this.authors.remove(author);
    }

    public void addQueuedUser(User user) {
        this.queuedUsers.add(user);
    }

    public boolean removeQueuedUser(User user) {
        return this.queuedUsers.remove(user);
    }

    public void addFavoriteUser(User user) {
        this.favoriteUsers.add(user);
    }

    public boolean removeFavoriteUser(User user) {
        return this.favoriteUsers.remove(user);
    }
}
