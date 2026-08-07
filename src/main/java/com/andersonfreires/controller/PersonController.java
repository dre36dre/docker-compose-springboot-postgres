package com.andersonfreires.controller;

import com.andersonfreires.entity.Person;
import com.andersonfreires.repository.PersonRepository;
import com.andersonfreires.service.PersonService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {



    private final PersonService service ;

    public PersonController(PersonService service,  PersonRepository personRepository) {
        this.service=service;
    }

    @GetMapping
    public List<Person> listAll() {
        return service.findAll() ;
    }
    
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
    	return service.findById(id);
    }
    
    
  @PostMapping
  public Person insert(@RequestBody Person person) {
	  return service.insert(person);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Person> update(@PathVariable Long id,@RequestBody Person person) {
	  Person updatePerson=service.update(id, person);
	  
	  return ResponseEntity.ok().body(updatePerson);
  }
  
  @DeleteMapping("/{id}") 
  public ResponseEntity<Void> delete(@PathVariable Long id){
	  service.delete(id);
	  
	  return ResponseEntity.noContent().build();
			  }
    
    
}