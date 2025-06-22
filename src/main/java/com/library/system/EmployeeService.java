package com.library.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
@AllArgsConstructor
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	

	/*
	 * This is an implementation of flux framework! 
	 */
	public Flux<Employee> getAll() {
		 
		return empRepo.findAll().switchIfEmpty(Flux.empty());
		 
		}

	
/*
 * Example of Mono.. 	
 */
	public Mono<Employee> getById(final String id) {
		 
		return empRepo.findById(id);
		 
		}
	

	public Mono update(final String id, final Employee employee) {
		 
		return empRepo.save(employee);
		 
		}
		 
		public Mono save(final Employee employee) {
		 
		return empRepo.save(employee);
		 
		}

}
