package net.nebula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.nebula.entity.User;

@RestController
public class ApiController {
	
	
//	public ResponseEntity<String> getMsg() {
//		
//		return new ResponseEntity<>("hello", HttpStatus);
//	}
//	
	
	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		//implemented logic to save user
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		//implemented logic for get user by id
		return new ResponseEntity<>(new User(1,"sagar","pssword"),HttpStatus.OK);
	}
}
