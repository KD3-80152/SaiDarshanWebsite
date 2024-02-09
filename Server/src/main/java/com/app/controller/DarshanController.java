package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DarshanDTO;
import com.app.service.DarshanService;





@RestController
@RequestMapping("/darshan")
@Validated

public class DarshanController {
	
	@Autowired
	private DarshanService darshanService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDarshanBooking(@RequestBody
			@Valid DarshanDTO darshan) {
		System.out.println("in add darshan " + darshan);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(darshanService.addDarshanBooking(darshan));
	}
	
	@GetMapping(value = "/view/{userId}")
	public ResponseEntity<?> getDarshanBookingsByUser(@PathVariable Long userId) throws IOException {
		System.out.println("get darshan bookings by user " + userId);
		return ResponseEntity.ok(darshanService.getAllDarshanBookingsByUserId(userId));
		
	}

}
