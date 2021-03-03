package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Alien;

@RestController
public class AlienResource {

	@Autowired
	private AlienRepository repo;

	@RequestMapping("aliens")
	public List<Alien> getAliens() {
		return (List<Alien>) repo.findAll();

	}
}
