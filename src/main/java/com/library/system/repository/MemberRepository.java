package com.library.system.repository;
import com.library.system.model.*;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MemberRepository extends ReactiveMongoRepository<Member, String> {
}
