package com.andersonfreires.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersonfreires.entity.Person;



public interface PersonRepository  extends JpaRepository<Person, Long>  {

}
