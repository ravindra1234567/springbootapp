package com.nagarro.test.backend.services;

import java.util.Set;

import com.nagarro.test.backend.model.User;
import com.nagarro.test.backend.model.UserRole;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    // create usr
    public User createUser(User user, Set<UserRole> userRole) throws Exception;

    // get user by username
    public User getUser(String username);

    // delete user by id
    public void deleteUser(Long userId);

    // get all users 
    public Long getAllUsers();

}
