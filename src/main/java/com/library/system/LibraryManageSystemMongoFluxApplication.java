package com.library.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManageSystemMongoFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManageSystemMongoFluxApplication.class, args);
		System.out.println("Spring Boot Webflux App started");

	}

}
