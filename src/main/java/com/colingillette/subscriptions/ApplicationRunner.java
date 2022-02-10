package com.colingillette.subscriptions;

import com.colingillette.subscriptions.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@Order(1)
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) {
        mongoTemplate.dropCollection(Author.class);
        mongoTemplate.dropCollection(Channel.class);
        mongoTemplate.dropCollection(Entry.class);
        mongoTemplate.dropCollection(Provider.class);
        mongoTemplate.dropCollection(User.class);

        List<Author> authors = getAuthors();
        List<Channel> channels = getChannels();
        List<Entry> entries = getEntries();
        List<Provider> providers = getProviders();
        List<User> users = getUsers();
        Random ran = new Random();

        for (Entry entry : entries) {
            entry.setAuthors(Arrays.asList(authors.get(ran.nextInt(authors.size())),
                    authors.get(ran.nextInt(authors.size()))));
            entry.setProvider(providers.get(ran.nextInt(providers.size())));
            entry.setChannel(channels.get(ran.nextInt(channels.size())));
        }

        for (User user : users) {
            user.setSubscribedChannels(Arrays.asList(channels.get(ran.nextInt(channels.size())),
                    channels.get(ran.nextInt(channels.size()))));
            user.setFavoriteEntries(Arrays.asList(entries.get(ran.nextInt(entries.size()))));
            user.setQueuedEntries(Arrays.asList(entries.get(ran.nextInt(entries.size())),
                    entries.get(ran.nextInt(entries.size()))));
        }

        mongoTemplate.insertAll(providers);
        mongoTemplate.insertAll(channels);
        mongoTemplate.insertAll(authors);
        mongoTemplate.insertAll(entries);
        mongoTemplate.insertAll(users);
    }

    private List<Author> getAuthors() {
        return Arrays.asList(
                new Author("Yahtzee", "Video game critic and developer."),
                new Author("Markiplier", "Let's Player and podcaster."),
                new Author("Jack Packard", "Movie and Tabletop game enthusiast."),
                new Author("Don Yates", "Software developer."),
                new Author("Phil Wright", "Business Analyst.")
        );
    }

    private List<Channel> getChannels() {
        return Arrays.asList(
                new Channel("Markiplier Channel", "Markliplier's Channel", "https://youtube.com/markiplier"),
                new Channel("The Escapist", "Video Game and Movie Review", "https://youtube.com/escapist"),
                new Channel("Software Developers Audio Blog", "Podcast about software development", "https://podcast.com/dev"),
                new Channel("Business Writes", "Blog about business stuff", "https://medium.com/business")
        );
    }

    private List<Entry> getEntries() {
        return Arrays.asList(
                new Entry("Audio 1", "Test Description Audio 1.", 45, LocalDateTime.now(), MediaType.Audio),
                new Entry("Audio 2", "Test Description Audio 2.", 64, LocalDateTime.now(), MediaType.Audio),
                new Entry("Audio 3", "Test Description Audio 3.", 47, LocalDateTime.now(), MediaType.Audio),
                new Entry("Audio 4", "Test Description Audio 4.", 39, LocalDateTime.now(), MediaType.Audio),
                new Entry("Text 1", "Test Description Text 1.", 13, LocalDateTime.now(), MediaType.Text),
                new Entry("Text 2", "Test Description Text 2.", 7, LocalDateTime.now(), MediaType.Text),
                new Entry("Text 3", "Test Description Text 3.", 6, LocalDateTime.now(), MediaType.Text),
                new Entry("Text 4", "Test Description Text 4.", 18, LocalDateTime.now(), MediaType.Text),
                new Entry("Text 5", "Test Description Text 5.", 14, LocalDateTime.now(), MediaType.Text),
                new Entry("Video 1", "Test Description Video 1.", 22, LocalDateTime.now(), MediaType.Video),
                new Entry("Video 2", "Test Description Video 2.", 9, LocalDateTime.now(), MediaType.Video),
                new Entry("Video 3", "Test Description Video 3.", 38, LocalDateTime.now(), MediaType.Video),
                new Entry("Video 4", "Test Description Video 4.", 16, LocalDateTime.now(), MediaType.Video)
        );
    }

    private List<Provider> getProviders() {
        return Arrays.asList(
                new Provider("YouTube", "Video sharing site.", "https://youtube.com"),
                new Provider("Podcasts", "Audio sharing platform.", "https://podcast.com"),
                new Provider("Medium", "Blog hosting site.", "https://medium.com")
        );
    }

    private List<User> getUsers() {
        return Arrays.asList(
                new User("ttest@gmail.com"),
                new User("testtest@yahoo.com"),
                new User("test3@outlook.com"),
                new User("tstest@gmail.com"),
                new User("ttt@yahoo.com"),
                new User("testing@gmail.com"),
                new User("t365@outlook.com"),
                new User("loremipsum@gmail.com"),
                new User("forty33@yahoo.com"),
                new User("testingtest@outlook.com")
        );
    }
}
