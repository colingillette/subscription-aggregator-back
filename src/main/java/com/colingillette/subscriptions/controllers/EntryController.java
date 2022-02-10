package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Entry;
import com.colingillette.subscriptions.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @GetMapping("/entries")
    public List<Entry> all() {
        return entryRepository.findAll();
    }
}
