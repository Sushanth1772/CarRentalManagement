package com.cts.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.demo.dto.SignInDto;
import com.cts.demo.dto.SignUpDto;
import com.cts.demo.exception.ResourceAlreadyExistsException;
import com.cts.demo.model.Roles;
import com.cts.demo.model.User;
import com.cts.demo.repository.RolesRepository;
import com.cts.demo.repository.UserRepository;
import com.cts.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String login(SignInDto signInDto) {
		// TODO Auto-generated method stub
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getUsername(),
				signInDto.getPassword()));
				SecurityContextHolder
				.getContext()
				.setAuthentication(authenticate);
		return "User logged in successfully!!!";
	}

	 @Override
	    public String register(SignUpDto signUpDto) {
	        // checking if phone number already used
	        if(userRepository.existsByUsername(signUpDto.getUsername())){
	            throw new ResourceAlreadyExistsException(HttpStatus.BAD_REQUEST, "User name already exists");
	        }
	        if(userRepository.existsByEmail(signUpDto.getEmail())){
	            throw new ResourceAlreadyExistsException(HttpStatus.BAD_REQUEST, "Email id already exists");
	        }

	        User user = new User();
	        user.setUsername(signUpDto.getUsername());
	        user.setEmail(signUpDto.getEmail());
	        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

	        Set<Roles> roles = new HashSet<>();
	        Roles userRoles = rolesRepository.findByRole("ROLE_USER").get();
	        roles.add(userRoles);
	        user.setRoles(roles);
	        userRepository.save(user);

	        return "User registered successfully !!!";

	    }

}
