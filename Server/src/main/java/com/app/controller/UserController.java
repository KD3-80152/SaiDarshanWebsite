package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/signin")
public class UserController {

	@Autowired
	private UserService userService;
	
	//method=GET
	// http://host:port/signin/{userId} 
	@GetMapping("my_profile/{userId}")
	public ResponseEntity<?> showUserProfile(@PathVariable Long userId) {
		System.out.println("in show profile " + userId );
		return ResponseEntity.ok(userService.getUserProfile(userId));
	}
	
	
	  //method=PUT
	  // http://host:port/signin/{userId} 
	//update the url according to front end
//	@PreAuthorize("hasRole('USER')")
		@PutMapping("my_profile/update_user/{userId}")
		public ResponseEntity<?> updateUserDetails(@PathVariable Long userId, @RequestBody @Valid UserDTO dto) {
			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(userService.updateUser(userId, dto));
		}
		
		
		
		
	//method=delete
	// http://host:port/signin/{userId} 
//		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/{userId}")
		public ResponseEntity<?> deleteUser(@PathVariable Long userId)
		{
			System.out.println("in delete user " + userId + " ");
			return ResponseEntity.ok(userService.deleteUserDetails(userId));
		}
	
	//method =patch
	//change password
	@PatchMapping("/change_password/{userId}")
	public ResponseEntity<?> changePassword(@PathVariable Long userId,@RequestBody @Valid UserDTO dto)
	{
		System.out.println("in change password "+ userId + " ");
		return ResponseEntity.ok(userService.changeUserPassword(userId,dto));
	}
}
