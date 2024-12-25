package com.cts.demo.service;

import java.util.List;

import com.cts.demo.model.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User UpdateUser(User user,long id);
	void deleteUser(long id);
}
