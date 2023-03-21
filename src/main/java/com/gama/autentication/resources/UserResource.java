package com.gama.autentication.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.autentication.entities.User;
import com.gama.autentication.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/insert")
	public ResponseEntity<User> insert(@RequestBody User user) {
		user = userService.insert(user);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/autentication")
	public ResponseEntity<Boolean> autentication (@RequestParam String email, @RequestParam String tryPassword) {
		return userService.autentication(email, tryPassword);
	}
}
