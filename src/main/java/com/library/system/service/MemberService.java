package com.library.system.service;
import com.library.system.model.*;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.library.system.repository.*;

@Transactional
@Service
@AllArgsConstructor
public class MemberService {

	@Autowired
    private MemberRepository memberRepo;

    public Flux<Member> getAll() {
        return memberRepo.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Member> getById(String id) {
        return memberRepo.findById(id);
    }

    public Mono<Member> save(Member member) {
        return memberRepo.save(member);
    }

    public Mono<Member> update(String id, Member member) {
        member.setMembId(id);
        return memberRepo.save(member);
    }

    public Mono<Void> delete(String id) {
        return memberRepo.deleteById(id);
    }
}
