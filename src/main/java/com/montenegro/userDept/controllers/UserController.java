package com.montenegro.userDept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montenegro.userDept.entities.User;
import com.montenegro.userDept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAllUsers() {
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findUserById(@PathVariable Long id) {		
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public User insertUser(@RequestBody User user) {		
		User result = repository.save(user);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {		
		repository.deleteById(id);
		return "Produto deletado com sucesso";
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		
		repository.deleteById(id);
		user.setId(id);
		repository.save(user);
		
		return user;
	}	
}