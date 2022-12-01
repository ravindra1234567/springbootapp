package com.nagarro.test.backend.controller;

import java.security.Principal;

import com.nagarro.test.backend.config.JwtUtils;
import com.nagarro.test.backend.model.JwtRequest;
import com.nagarro.test.backend.model.JwtResponse;
import com.nagarro.test.backend.model.User;
import com.nagarro.test.backend.services.CommentService;
import com.nagarro.test.backend.services.ProductService;
import com.nagarro.test.backend.services.UserService;
import com.nagarro.test.backend.services.impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;
    
    // generate token
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("User not found 123");
        }
        // authenticate
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            System.out.println("username == "+ username);
            System.out.println("username == "+ password);

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User disabled" + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials " + e.getMessage());
        }
    }

    // return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        System.out.println("current user === " + principal);
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }

    // get total product count
    @GetMapping("/count")
    public Long count() {
        return this.productService.count();
    }

    // get all users
    @GetMapping("/allusers")
    public Long getAllUsers() {
        return this.userService.getAllUsers();
    }

    // get all comments
    @GetMapping("/allcomments")
    public Long getAllComments() {
        return this.commentService.count();
    }

}
