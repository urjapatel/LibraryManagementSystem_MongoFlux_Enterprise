package com.library.system.controller;

import com.library.system.model.Publisher;
import com.library.system.model.Book;
import com.library.system.service.BookService;
import com.library.system.service.PublisherService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/publishers")
@AllArgsConstructor
public class PublisherController {

	@Autowired
    private PublisherService publisherService;

	@Autowired
    private BookService bookService;

	
    @GetMapping
    public Flux<Publisher> getAll() {
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Publisher> getById(@PathVariable String id) {
        return publisherService.getById(id);
    }

    @PostMapping
    public Mono<Publisher> create(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @PutMapping("/{id}")
    public Mono<Publisher> update(@PathVariable String id, @RequestBody Publisher publisher) {
        return publisherService.update(id, publisher);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return publisherService.delete(id);
    }
    
    @GetMapping("/{id}/books")
    public Flux<Book> getBooksByPublisher(@PathVariable("id") String publisherId) {
        return bookService.getBooksByPublisher(publisherId);
    }

}
