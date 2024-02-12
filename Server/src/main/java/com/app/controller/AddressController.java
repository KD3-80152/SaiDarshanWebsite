package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.service.AddressService;

@RestController
@RequestMapping("/signin/my_profile/")
public class AddressController {

	@Autowired
	private AddressService addrService;
	
	
	
	//method=Post
		 // http://host:port/signin/my_profile/update_address/{userId} 
		//update the url according to front end
//		@PreAuthorize("hasRole('USER')")
			@PostMapping("address/add_address/{userId}")
			public ResponseEntity<?> assignUserAddress(@PathVariable Long userId, @RequestBody @Valid AddressDTO dto) {
				System.out.println("in update user " + userId + " " + dto);
				return ResponseEntity.ok(addrService.asssignAddress(userId, dto));
			}
	
	
	
	//method=PUT
	 // http://host:port/signin/my_profile/update_address/{userId} 
	//update the url according to front end
//	@PreAuthorize("hasRole('USER')")
		@PutMapping("address/update_address/{userId}")
		public ResponseEntity<?> updateUserAddress(@PathVariable Long userId, @RequestBody @Valid AddressDTO dto) {
			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(addrService.updateAddress(userId, dto));
		}
	
}
