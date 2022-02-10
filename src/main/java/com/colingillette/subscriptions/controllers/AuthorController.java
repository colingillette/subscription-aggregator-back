package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Author;
import com.colingillette.subscriptions.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> all() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author one(@PathVariable String id) {
        return authorRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/authors")
    public Author create(@RequestBody Author author) {
        return authorRepository.insert(author);
    }

    @PutMapping("/authors/{id}")
    public Author update(@PathVariable String id, @RequestBody Author newAuthor) {
        Author author = authorRepository.findById(id).orElseThrow(RuntimeException::new);

        author.setName(newAuthor.getName());
        author.setBio(newAuthor.getBio());

        return authorRepository.save(author);
    }

    @DeleteMapping("/authors/{id}")
    public void delete(@PathVariable String id) {
        authorRepository.deleteById(id);
    }
}
