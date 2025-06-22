package com.library.system.repository;

import com.library.system.model.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PublisherRepository extends ReactiveMongoRepository<Publisher, String> {
}
