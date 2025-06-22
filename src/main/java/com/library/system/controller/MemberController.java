package com.library.system.controller;

import com.library.system.model.*;
import com.library.system.service.*;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

	@Autowired
    private MemberService memberService;

    @GetMapping
    public Flux<Member> getAll() {
        System.out.println("Fetching all members");
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Member> getById(@PathVariable String id) {
        System.out.println("Fetching member by ID");
        return memberService.getById(id);
    }

    @PostMapping
    public Mono<Member> create(@RequestBody Member member) {
        System.out.println("Creating new member: " + member.getName());
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public Mono<Member> update(@PathVariable String id, @RequestBody Member updated) {
        System.out.println("Updating member with ID: " + id);
        return memberService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        System.out.println("Deleting member with ID: " + id);
        return memberService.delete(id);
    }
}
