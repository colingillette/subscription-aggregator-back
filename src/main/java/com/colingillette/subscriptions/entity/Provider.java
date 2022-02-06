package com.colingillette.subscriptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provider represents a service provider like YouTube, Netflix, and Podcasts.
 * If applicable: Podcast groups like EarWolf, Maximum Fun, or others may be a Provider.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Provider {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Lob
    private Byte[] thumbnail;

    @OneToMany
    private List<Channel> channels;

    @ManyToMany
    private List<Author> authors;

    @ManyToMany
    private List<User> subscribedUsers;

    public Provider() {
        super();
        this.channels = new ArrayList<>();
        this.subscribedUsers = new ArrayList<>();
    }

    public Provider(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    public boolean removeChannel(Channel channel) {
        return this.channels.remove(channel);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public boolean removeAuthor(Author author) {
        return this.authors.remove(author);
    }

    public void addSubscribedUser(User user) {
        this.subscribedUsers.add(user);
    }

    public boolean removeSubscribedUser(User user) {
        return this.subscribedUsers.remove(user);
    }
}
