package com.library.system.controller;

import com.library.system.model.Book;
import com.library.system.service.BookService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

	@Autowired
    private BookService bookService;

    @GetMapping
    public Flux<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> getById(@PathVariable String id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PostMapping("/publisher/{publisherId}")
    public Mono<Book> createWithPublisher(@PathVariable String publisherId, @RequestBody Book book) {
        return bookService.saveWithPublisher(publisherId, book);
    }

    @PutMapping("/{id}")
    public Mono<Book> update(@PathVariable String id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return bookService.delete(id);
    }
}
