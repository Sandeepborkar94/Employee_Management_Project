package com.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}