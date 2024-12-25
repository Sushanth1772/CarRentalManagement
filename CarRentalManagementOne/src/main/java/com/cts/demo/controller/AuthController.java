package com.cts.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.demo.dto.SignInDto;
import com.cts.demo.dto.SignUpDto;
import com.cts.demo.repository.UserRepository;
import com.cts.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody(required=true) @Valid SignUpDto signUpDto){
		return new ResponseEntity<>(authService.register(signUpDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<String> signin(@RequestBody(required=true) @Valid SignInDto signInDto){
		return new ResponseEntity<>(authService.login(signInDto),HttpStatus.OK);
	}
}
