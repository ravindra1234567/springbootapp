package com.nagarro.test.backend.services.impl;

import java.util.Set;

import com.nagarro.test.backend.model.User;
import com.nagarro.test.backend.model.UserRole;
import com.nagarro.test.backend.repo.RoleRepository;
import com.nagarro.test.backend.repo.UserRepository;
import com.nagarro.test.backend.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        // TODO Auto-generated method stub

        User local = this.userRepository.findByUsername(user.getUsername());

        if (local != null) {
            System.out.println("User is already there !!");
            throw new NotFoundException("User is already register !!");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    // getting user by username
    @Override
    public User getUser(String username) {
        // TODO Auto-generated method stub
        return this.userRepository.findByUsername(username);
    }

    // delete user by id
    @Override
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        this.userRepository.deleteById(userId);
    }

    @Override
    public Long getAllUsers() {
        // TODO Auto-generated method stub
        return this.userRepository.count();

    }
    
}
