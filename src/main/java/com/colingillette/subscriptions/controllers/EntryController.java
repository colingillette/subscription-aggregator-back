package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Entry;
import com.colingillette.subscriptions.models.MediaType;
import com.colingillette.subscriptions.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @GetMapping("/entries")
    public List<Entry> all() {
        return entryRepository.findAll();
    }

    @GetMapping("/entries/{id}")
    public Entry one(@PathVariable String id) {
        return entryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/entries/type/{type}")
    public List<Entry> findByMediaType(@PathVariable MediaType type) {
        return entryRepository.findByMediaType(type);
    }

    @PostMapping("/entries")
    public Entry create(@RequestBody Entry entry) {
        return entryRepository.insert(entry);
    }

    @PutMapping("/entries/{id}")
    public Entry update(@PathVariable String id, @RequestBody Entry newEntry) {
        Entry entry = entryRepository.findById(id).orElseThrow(RuntimeException::new);

        entry.setName(newEntry.getName());
        entry.setDescription(newEntry.getDescription());
        entry.setLength(newEntry.getLength());
        entry.setMediaType(newEntry.getMediaType());
        entry.setReleaseTimeStamp(newEntry.getReleaseTimeStamp());
        entry.setFavorite(newEntry.isFavorite());
        entry.setChannel(newEntry.getChannel());
        entry.setProvider(newEntry.getProvider());
        entry.setAuthors(newEntry.getAuthors());

        return entryRepository.save(entry);
    }

    @DeleteMapping("/entries/{id}")
    public void delete(@PathVariable String id) {
        entryRepository.deleteById(id);
    }
}
