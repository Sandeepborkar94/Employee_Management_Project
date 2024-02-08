package com.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}