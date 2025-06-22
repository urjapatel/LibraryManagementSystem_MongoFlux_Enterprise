package com.library.system.service;

import com.library.system.model.Book;
import com.library.system.model.Publisher;
import com.library.system.repository.BookRepository;
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
public class BookService {

	@Autowired
    private BookRepository bookRepo;

	@Autowired
	private PublisherRepository publisherRepo;

    public Flux<Book> getAll() {
        return bookRepo.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Book> getById(String id) {
        return bookRepo.findById(id);
    }

    public Mono<Book> save(Book book) {
        return bookRepo.save(book);
    }

    public Mono<Book> saveWithPublisher(String publisherId, Book book) {
        return publisherRepo.findById(publisherId)
                .flatMap(pub -> {
                    book.setPublisherId(pub.getPubId()); // set only the ID
                    return bookRepo.save(book);
                });
    }

    public Mono<Book> update(String id, Book book) {
        book.setBookId(id);
        return bookRepo.save(book);
    }

    public Mono<Void> delete(String id) {
        return bookRepo.deleteById(id);
    }
    
    public Flux<Book> getBooksByPublisher(String publisherId) {
        return bookRepo.findAll()
                .filter(book -> publisherId.equals(book.getPublisherId()));
    }

}
