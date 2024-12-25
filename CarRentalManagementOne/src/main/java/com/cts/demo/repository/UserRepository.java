package com.cts.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmailOrUsername(String email,String username);
	
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}
