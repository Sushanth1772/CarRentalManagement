package com.cts.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.demo.exception.ResourceNotFoundException;
import com.cts.demo.model.User;
import com.cts.demo.repository.UserRepository;
import com.cts.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
//		User user = userRepository.findById(id);
		return userRepository.findById(id).orElseThrow(() ->
					new ResourceNotFoundException("User","Id",id));
	}

	@Override
	public User UpdateUser(User user, long id) {
		// TODO Auto-generated method stub
		User  existingUser = userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User","Id",id));
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("User","Id",id));
		userRepository.deleteById(id);
		
	}

}
