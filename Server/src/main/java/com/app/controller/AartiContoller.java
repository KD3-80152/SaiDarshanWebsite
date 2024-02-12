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

import com.app.dto.AartiRequestDTO;
import com.app.security.FindUserDetails;
import com.app.service.AartiService;

//https://localhost:8443/swagger-ui/index.html#/

@RestController
@RequestMapping("/aarti")
public class AartiContoller 
{
	@Autowired
	private AartiService artiService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//method=POST
	// http://host:port/aarti/add
	@PostMapping("/add")
	public ResponseEntity<?> addAartiBooking(@RequestBody
			@Valid AartiRequestDTO aarti) {
		Long userId = authUserDetails.getUserId();
		System.out.println("in add darshan " + aarti);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(artiService.addAartiBooking(aarti,userId));
	}
	
	//method=GET
		// http://host:port/aarti/
	@GetMapping(value = "/")
	public ResponseEntity<?> getAartiBookingsByUser() throws IOException {
		Long userId = authUserDetails.getUserId();
		System.out.println("get aarti bookings by user " + userId);
		return ResponseEntity.ok(artiService.getAllAartiBookingsByUserId(userId));
		
	}
	

	//method=DELETE
		// http://host:port/aarti/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> cancelAartiBooking(@PathVariable Long id)
	{
		System.out.println("In Delete Aarti: " + id);
		return ResponseEntity.ok(artiService.deleteAartiBookingById(id));
	}
	
	
	
	//ADMIN POV GETTING ALL POOJA BOOKINGS
	@GetMapping("/all")
	public ResponseEntity<?> getAllAartiBookings()
	{
		System.out.println("Get All Aarti Bookings");
		return ResponseEntity.ok(artiService.getAllAartiBookings());
	}

	
	
}
