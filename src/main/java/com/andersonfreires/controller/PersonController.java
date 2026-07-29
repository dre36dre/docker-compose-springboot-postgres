package com.andersonfreires.controller;

import com.andersonfreires.entity.Person;
import com.andersonfreires.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> listAll() {
        return repository.findAll() ;
    }
}