package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PoojaRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.PoojaService;

@RestController
@RequestMapping("/pooja")
public class PoojaController {
	
	@Autowired
	private PoojaService poojaService;
	
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	
	//ADD NEW POOJA BOOKING
	//method=POST
	// http://host:port/pooja/add
	//UPDATE URL ACCORDING TO THE FRONT END FOR SIGNED IN USER
	@PostMapping("/add")
	public ResponseEntity<?> addNewPoojaBooking(@RequestBody
			@Valid PoojaRequestDTO pooja) {
		Long userId = authUserDetails.getUserId();
		System.out.println("in add darshan " + pooja);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(poojaService.addPoojaBooking(pooja,userId));
	}
	
	//GET PARTICULAR USER'S POOJA BOOKINGS
	//method=GET
	// http://host:port/pooja/
	@GetMapping("/")
	public ResponseEntity<?> getPoojaBookingsByUser() throws IOException 
	{
		Long userId = authUserDetails.getUserId();
		System.out.println("get Pooja bookings by user " + userId);
		return ResponseEntity.ok(poojaService.getAllPoojaBookingsByUserId(userId));
		
	}
	
	
	//CANCEL PARTICULAR USER'S POOJA BOOKINGS
	//method=DELETE
	// http://host:port/pooja/{id}
		
		@DeleteMapping("/{poojaId}")
		public ApiResponse cancelPoojaBooking(@PathVariable Long poojaId) {
			
			System.out.println("in cancel " + poojaId);
			return poojaService.deletePoojaBookingById(poojaId);
		}
		
		
	//ADMIN POV GETTING ALL POOJA BOOKINGS
		//method=GET
		// http://host:port/pooja/all
		@GetMapping("/all")
		public ResponseEntity<?> getAllPoojaBookings() throws IOException 
		{
			
			System.out.println("get Pooja bookings");
			return ResponseEntity.ok(poojaService.getAllPoojaBookings());
			
		}
}
