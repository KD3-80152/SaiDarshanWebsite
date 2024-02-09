package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.PoojaDTO;
import com.app.service.PoojaService;

@RestController
@RequestMapping("/pooja")
public class PoojaController {
	
	@Autowired
	private PoojaService poojaService;
	
	@PostMapping
	public ResponseEntity<?> addDarshanBooking(@RequestBody
			@Valid PoojaDTO pooja) {
		System.out.println("in add darshan " + pooja);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(poojaService.addPoojaBooking(pooja));
	}
	

	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> getPoojaBookingsByUser(@PathVariable Long userId) throws IOException {
		System.out.println("get Pooja bookings by user " + userId);
		return ResponseEntity.ok(poojaService.getAllPoojaBookingsByUserId(userId));
		
	}
	
	
	
	
	

}
