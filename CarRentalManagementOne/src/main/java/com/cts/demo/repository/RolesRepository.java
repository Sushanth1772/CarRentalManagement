package com.cts.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.demo.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByRole(String role);
}
