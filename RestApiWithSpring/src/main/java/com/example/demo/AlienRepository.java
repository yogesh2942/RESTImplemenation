package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.Alien;

//JPA Example to fetch the data from the database
public interface AlienRepository extends CrudRepository<Alien, Integer> {

}
