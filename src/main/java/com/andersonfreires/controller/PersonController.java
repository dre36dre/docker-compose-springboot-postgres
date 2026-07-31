package com.andersonfreires.controller;

import com.andersonfreires.entity.Person;
import com.andersonfreires.repository.PersonRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> listAll() {
        return repository.findAll() ;
    }
    
    @PostMapping
    public Person create(@RequestBody Person person) {
    	return repository.save(person);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id,@RequestBody Person obj) {
    	Person person=repository.findById(id).orElseThrow();
    	
    	person.setName(obj.getName());
    	person.setAge(obj.getAge());
    	person.setCity(obj.getCity());
    	
    	person=repository.save(person);
    	
    	return ResponseEntity.ok().body(person);
    }
    
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	repository.deleteById(id);
    	return ResponseEntity.noContent().build();    	
    }
    
    
    
    
    
}