package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.User;
import com.colingillette.subscriptions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> all() {
        return userRepository.findAll();
    }
}
