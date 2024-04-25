package io.github.swarnaka.userauthservice.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.swarnaka.userauthservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	
	@Autowired
	private UserService userService;
	
	 @PostMapping("/login")
	    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> credentials) {
		 
	        boolean isAuthenticated = userService.authenticate(credentials.get("username"), credentials.get("password"));
	        if (isAuthenticated) {
	            // Generate token and return it
	            String token = UUID.randomUUID().toString();
	            return ResponseEntity.ok(Map.of(
	                "authentication_token", token,
	                "status_code", "S1000",
	                "status_description", "Success"
	            ));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
	                "status_code", "S1001",
	                "status_description", "Authentication Failed"
	            ));
	        }
	    }
	 
	 
}
