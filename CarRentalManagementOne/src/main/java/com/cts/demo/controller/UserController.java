package com.cts.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.dto.UserDto;
import com.cts.demo.model.User;
import com.cts.demo.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/api/v1")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserDto userdto){
		User user = mapToEntity(userdto);
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<User> UpdateUser(@Valid @RequestBody UserDto userdto,@PathVariable("id") long id){
		User user = mapToEntity(userdto);
		return new ResponseEntity<User>(userService.UpdateUser(user, id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("Employee deleted successfully!.",HttpStatus.OK);
	}
	
	private User mapToEntity(UserDto userdto) {
		User user = new User();
//		user.setId(userdto.getId());
		user.setUsername(userdto.getUsername());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		return user;
	}
}
