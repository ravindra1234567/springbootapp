package com.nagarro.test.backend.repo;

import com.nagarro.test.backend.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    
}
