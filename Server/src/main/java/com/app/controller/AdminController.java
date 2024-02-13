package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.FindUserDetails;
import com.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	
	//ADMIN POV GET ALL USERS
			//method=get
			// http://host:port/signin/user
			@GetMapping("/all-users")
			public ResponseEntity<?> getAllUsers()
			{
				System.out.println("in get all users admin pov");
				return ResponseEntity.ok(userService.getAllUsers());
			}
			
			
			//ADMIN POV DELETE USER BY ID
			//method=delete
			// http://host:port/signin/user/{id}
				
				@DeleteMapping("/all-users/{id}")
				public ResponseEntity<?> deleteUser()
				{
					Long userId = authUserDetails.getUserId();
					System.out.println("in delete user " + userId + " ");
					return ResponseEntity.ok(userService.deleteUserDetails(userId));
				}
	
	
}
