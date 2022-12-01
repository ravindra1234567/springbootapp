package com.nagarro.test.backend;

import java.util.HashSet;
import java.util.Set;

import com.nagarro.test.backend.model.Role;
import com.nagarro.test.backend.model.User;
import com.nagarro.test.backend.model.UserRole;
import com.nagarro.test.backend.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("String........ port no. 8086 ");

		try {
			User user = new User();
			user.setFirstName("Ravindra");
			user.setLastName("Kushwaha");
			user.setUsername("ravindra123");
			user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
			// user.setPassword("123456");
			user.setEmail("abc@gamil.com");
			// user.setProfile("default.png");

			Role role1 = new Role();
			role1.setRoleId(44L);
			role1.setRoleName("ADMIN");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);

			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("User already there " + e);
		}

	}

}
