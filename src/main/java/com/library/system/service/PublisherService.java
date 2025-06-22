package com.library.system.service;

import com.library.system.model.Publisher;
import com.library.system.repository.PublisherRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
@AllArgsConstructor
public class PublisherService {

	@Autowired
    private PublisherRepository publisherRepo;

    public Flux<Publisher> getAll() {
        return publisherRepo.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Publisher> getById(String id) {
        return publisherRepo.findById(id);
    }

    public Mono<Publisher> save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    public Mono<Publisher> update(String id, Publisher publisher) {
        publisher.setPubId(id);
        return publisherRepo.save(publisher);
    }

    public Mono<Void> delete(String id) {
        return publisherRepo.deleteById(id);
    }
}
