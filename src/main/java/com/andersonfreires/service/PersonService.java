package com.andersonfreires.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.andersonfreires.entity.Person;
import com.andersonfreires.repository.PersonRepository;


@Service
public class PersonService {
	
	private final PersonRepository repository;

	public PersonService(PersonRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return  repository.findById(id)
				.orElseThrow(()  ->
				new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Person not found with id: "+id)
						);
	}
	
	public Person insert(Person person) {
		return repository.save(person);
	}
	
	public Person update(Long id,Person person) {
		Person existingPerson= repository.findById(id).orElseThrow();
		
		existingPerson.setName(person.getName());
		existingPerson.setAge(person.getAge());
		existingPerson.setCity(person.getCity());
		
		return repository.save(existingPerson);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
