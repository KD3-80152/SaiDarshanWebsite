package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserChangePasswordDTO;
import com.app.dto.UserDTO;
import com.app.security.FindUserDetails;
import com.app.service.UserService;

@RestController
@RequestMapping("/signin")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	
	//method=GET

	// http://host:port/signin/my_profile
	@GetMapping("/my_profile")
	public ResponseEntity<?> showUserProfile( @RequestBody @Valid UserDTO dto) {
		Long userId = authUserDetails.getUserId();
		System.out.println("in show profile " + userId + " " + dto);

		return ResponseEntity.ok(userService.getUserProfile(userId));
	}
	
	
	  //method=PUT
	  // http://host:port/signin/my_profile/update_user
	//update the url according to front end
		@PutMapping("/my_profile/update_user")
		public ResponseEntity<?> updateUserDetails( @RequestBody @Valid UserDTO dto) {
		Long userId = authUserDetails.getUserId();
			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(userService.updateUser(userId, dto));
		}
		
	
	//method =patch
	//change password
	// http://host:port/signin/change_password
	@PatchMapping("/change_password")
	public ResponseEntity<?> changePassword(@RequestBody @Valid UserChangePasswordDTO dto)
	{
		Long userId = authUserDetails.getUserId();
		System.out.println("in change password "+ userId + " ");
		return ResponseEntity.ok(userService.changeUserPassword(userId,dto));
	}
	
	//ADMIN POV GET ALL USERS
		//method=get
		// http://host:port/signin/user
		@GetMapping("/user")
		public ResponseEntity<?> getAllUsers()
		{
			System.out.println("in get all users admin pov");
			return ResponseEntity.ok(userService.getAllUsers());
		}
		
		
		//ADMIN POV DELETE USER BY ID
		//method=delete
		// http://host:port/signin/user/{id}
			@PreAuthorize("hasRole('ADMIN')")
			@DeleteMapping("/user/{id}")
			public ResponseEntity<?> deleteUser()
			{
				Long userId = authUserDetails.getUserId();
				System.out.println("in delete user " + userId + " ");
				return ResponseEntity.ok(userService.deleteUserDetails(userId));
			}
}
