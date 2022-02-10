package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Provider;
import com.colingillette.subscriptions.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;

    @GetMapping("/providers")
    public List<Provider> all() {
        return providerRepository.findAll();
    }

    @GetMapping("/providers/{id}")
    public Provider one(@PathVariable String id) {
        return providerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/providers")
    public Provider create(@RequestBody Provider provider) {
        return providerRepository.insert(provider);
    }

    @PutMapping("/providers/{id}")
    public Provider update(@PathVariable String id, @RequestBody Provider newProvider) {
        Provider provider = providerRepository.findById(id).orElseThrow(RuntimeException::new);

        provider.setName(newProvider.getName());
        provider.setDescription(newProvider.getDescription());
        provider.setUri(newProvider.getUri());

        return providerRepository.save(provider);
    }

    @DeleteMapping("/providers/{id}")
    public void delete(@PathVariable String id) {
        providerRepository.deleteById(id);
    }
}
