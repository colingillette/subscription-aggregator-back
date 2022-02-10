package com.colingillette.subscriptions.controllers;

import com.colingillette.subscriptions.models.Queue;
import com.colingillette.subscriptions.repositories.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QueueController {

    @Autowired
    QueueRepository queueRepository;

    @GetMapping("/queues")
    public List<Queue> all() {
        return queueRepository.findAllByOrderByTimeStampDesc();
    }

    @GetMapping("/queues/{id}")
    public Queue one(@PathVariable String id) {
        return queueRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping("/queues")
    public Queue create(@RequestBody Queue queue) {
        return queueRepository.insert(queue);
    }

    @PutMapping("/queues/{id}")
    public Queue update(@PathVariable String id, @RequestBody Queue newQueue) {
        Queue queue = queueRepository.findById(id).orElseThrow(RuntimeException::new);

        queue.setTimeStamp(newQueue.getTimeStamp());
        queue.setEntry(newQueue.getEntry());

        return queueRepository.save(queue);
    }

    @DeleteMapping("/queues/{id}")
    public void delete(@PathVariable String id) {
        queueRepository.deleteById(id);
    }
}
