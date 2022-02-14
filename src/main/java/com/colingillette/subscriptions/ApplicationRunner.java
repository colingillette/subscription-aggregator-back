package com.colingillette.subscriptions;

import com.colingillette.subscriptions.models.*;
import com.colingillette.subscriptions.models.Queue;
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
        mongoTemplate.dropCollection(Queue.class);

        List<Author> authors = getAuthors();
        List<Channel> channels = getChannels();
        List<Provider> providers = getProviders();
        Random ran = new Random();

        List<Entry> entries = getEntries(ran);
        for (Entry entry : entries) {
            entry.setAuthors(Arrays.asList(authors.get(ran.nextInt(authors.size())),
                    authors.get(ran.nextInt(authors.size()))));
            entry.setProvider(providers.get(ran.nextInt(providers.size())));
            entry.setChannel(channels.get(ran.nextInt(channels.size())));
        }

        List<Queue> queues = getQueues(entries, ran, 5);

        mongoTemplate.insertAll(providers);
        mongoTemplate.insertAll(channels);
        mongoTemplate.insertAll(authors);
        mongoTemplate.insertAll(entries);
        mongoTemplate.insertAll(queues);

        System.out.println("Application Started...");
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

    private List<Entry> getEntries(Random ran) {
        return Arrays.asList(
                new Entry("Audio 1", "Test Description Audio 1.", 45, LocalDateTime.now(), MediaType.Audio, ran.nextInt(54000)),
                new Entry("Audio 2", "Test Description Audio 2.", 64, LocalDateTime.now(), MediaType.Audio, ran.nextInt(54000)),
                new Entry("Audio 3", "Test Description Audio 3.", 99, LocalDateTime.now(), MediaType.Audio, ran.nextInt(54000)),
                new Entry("Audio 4", "Test Description Audio 4.", 39, LocalDateTime.now(), MediaType.Audio, ran.nextInt(54000)),
                new Entry("Text 1", "Test Description Text 1.", 88, LocalDateTime.now(), MediaType.Text, ran.nextInt(54000)),
                new Entry("Text 2", "Test Description Text 2.", 97, LocalDateTime.now(), MediaType.Text, ran.nextInt(54000)),
                new Entry("Text 3", "Test Description Text 3.", 62, LocalDateTime.now(), MediaType.Text, ran.nextInt(54000)),
                new Entry("Text 4", "Test Description Text 4.", 18, LocalDateTime.now(), MediaType.Text, ran.nextInt(54000)),
                new Entry("Text 5", "Test Description Text 5.", 143, LocalDateTime.now(), MediaType.Text, ran.nextInt(54000)),
                new Entry("Video 1", "Test Description Video 1.", 22, LocalDateTime.now(), MediaType.Video, ran.nextInt(54000)),
                new Entry("Video 2", "Test Description Video 2.", 90, LocalDateTime.now(), MediaType.Video, ran.nextInt(54000)),
                new Entry("Video 3", "Test Description Video 3.", 38, LocalDateTime.now(), MediaType.Video, ran.nextInt(54000)),
                new Entry("Video 4", "Test Description Video 4.", 167, LocalDateTime.now(), MediaType.Video, ran.nextInt(54000))
        );
    }

    private List<Provider> getProviders() {
        return Arrays.asList(
                new Provider("YouTube", "Video sharing site.", "https://youtube.com"),
                new Provider("Podcasts", "Audio sharing platform.", "https://podcast.com"),
                new Provider("Medium", "Blog hosting site.", "https://medium.com")
        );
    }

    private List<Queue> getQueues(List<Entry> entries, Random ran, int length) {
        List<Queue> qList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            Queue q = new Queue(entries.get(ran.nextInt(entries.size())));
            q.setTimeStamp(LocalDateTime.now().minusMinutes(i));
            qList.add(q);
        }

        return qList;
    }
}
