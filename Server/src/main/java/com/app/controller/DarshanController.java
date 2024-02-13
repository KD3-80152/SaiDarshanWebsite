package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DarshanRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.DarshanService;


@RestController
@RequestMapping("/darshan")
@Validated


public class DarshanController {
	
	@Autowired
	private DarshanService darshanService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//ADD NEW DARSHAN BOOKING
	//method=POST
	// http://host:port/darshan/add
	@PostMapping("/add")
	public ResponseEntity<?> addDarshanBooking(@RequestBody
			@Valid DarshanRequestDTO darshan) {
		System.out.println("in add darshan " + darshan);
		Long userId = authUserDetails.getUserId();
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(darshanService.addDarshanBooking(darshan,userId));
	}
	
	
	//GET PARTICULAR USER'S DARSHAN BOOKINGS
	//method=GET
	// http://host:port/darshan/
	@GetMapping(value = "/")
	public ResponseEntity<?> getDarshanBookingsByUser() throws IOException 
	{
		Long userId = authUserDetails.getUserId();
		System.out.println("get darshan bookings by user " + userId);
		return ResponseEntity.ok(darshanService.getAllDarshanBookingsByUserId(userId));	
	}
	
	//CANCEL PARTICULAR USER'S DARSHAN BOOKINGS
	//method=DELETE
	// http://host:port/darshan/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> cancelDarshanBooking(@PathVariable Long id) 
	{
		
		
		System.out.println("in delete darshan " + id);
		return ResponseEntity.ok(darshanService.deleteDarshanBookingById(id));
	}
	
	//ADMIN POV GETTING ALL DARSHAN BOOKINGS
	//method=GET
			// http://host:port/darshan/all
	@GetMapping("/all")
	public ResponseEntity<?> getAllDarshanBookings()
	{
		System.out.println("Get All Darshan Bookings");
		return ResponseEntity.ok(darshanService.getAllDarshanBookings());
	}
	

}
