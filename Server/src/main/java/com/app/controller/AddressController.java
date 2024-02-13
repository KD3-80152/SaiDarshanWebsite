package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.security.FindUserDetails;
import com.app.service.AddressService;

@RestController
@RequestMapping("/signin/my_profile/address")
public class AddressController {

	@Autowired
	private AddressService addrService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
		//method=get
		//http://host:port/signin/my_profile/address 
		//update the url according to front end
		@GetMapping
		public ResponseEntity<?> getUserAddress() {
			
			Long userId = authUserDetails.getUserId();
			System.out.println("in update user " + userId);
			return ResponseEntity.ok(addrService.getAddressDetails(userId));
			
		}
	
	
	    //method=Post
		// http://host:port/signin/my_profile/address/add_address
		//update the url according to front end

		
			@PostMapping("/add_address")
			public ResponseEntity<?> assignUserAddress( @RequestBody @Valid AddressDTO dto) {
			Long userId = authUserDetails.getUserId();

				System.out.println("in update user " + userId + " " + dto);
				return ResponseEntity.ok(addrService.asssignAddress(userId, dto));
			}
	
	
	
	//method=PUT
	 // http://host:port/signin/my_profile/address/update_address
	//update the url according to front end

	
		@PutMapping("/update_address")
		public ResponseEntity<?> updateUserAddress(@RequestBody @Valid AddressDTO dto) 
		{
			Long userId = authUserDetails.getUserId();

			System.out.println("in update user " + userId + " " + dto);
			return ResponseEntity.ok(addrService.updateAddress(userId, dto));
		}
	
}
