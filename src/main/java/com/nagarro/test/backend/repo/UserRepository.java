package com.nagarro.test.backend.repo;

import com.nagarro.test.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long >{
    public User  findByUsername(String username);
}
