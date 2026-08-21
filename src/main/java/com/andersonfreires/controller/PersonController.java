package com.andersonfreires.controller;

import com.andersonfreires.entity.Person;
import com.andersonfreires.service.PersonService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    // GET /people -> lista todas as pessoas
    @GetMapping
    public List<Person> listAll() {
        return service.findAll();
    }

    // GET /people/hello -> endpoint de teste/saudação
    @GetMapping("/hello")
    public String hello() {
        return "Hello from People API v1.1!";
    }

    // GET /people/{id} -> busca pessoa por ID numérico
    //@GetMapping("/{id}")
   // public Person findById(@PathVariable Long id) {
     //   return service.findById(id);
   // }

    // POST /people -> insere nova pessoa
    @PostMapping
    public Person insert(@RequestBody Person person) {
        return service.insert(person);
    }

    // PUT /people/{id} -> atualiza pessoa existente
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        Person updatePerson = service.update(id, person);
        return ResponseEntity.ok().body(updatePerson);
    }

    // DELETE /people/{id} -> remove pessoa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
