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

import com.app.dto.AccommodationDTO;
import com.app.dto.DarshanDTO;
import com.app.security.FindUserDetails;
import com.app.service.AccommodationService;

@RestController
@RequestMapping("/accommodation")
@Validated
public class AccommodationController {
	 
	@Autowired
	private AccommodationService accoService;
	
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	//method=POST
	// http://host:port/accommodation/add
	@PostMapping("/add")
	public ResponseEntity<?> addAccommodationBooking(@RequestBody
			@Valid AccommodationDTO acco) {
		System.out.println("in add accommodation " + acco);
		Long userId = authUserDetails.getUserId();
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(accoService.addAccomodationBooking(acco,userId));
	}
	
	//method=GET
	// http://host:port/accommodation/
	@GetMapping(value = "/")
	public ResponseEntity<?> getAccommodationBookingsByUser() throws IOException {
		Long userId = authUserDetails.getUserId();
		System.out.println("get accommodation bookings by user " + userId);
		return ResponseEntity.ok(accoService.getAllAccommodationBookingsByUserId(userId));
	}
	
	//method=DELETE
		// http://host:port/accommodation/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccommodationDetails(@PathVariable Long id) {
		System.out.println("in update accommodation" + id);
		return ResponseEntity.ok(accoService.deleteAccomodationBookingById(id));
	}
	
	
	//ADMIN POV GETTING ALL POOJA BOOKINGS
	@GetMapping("/all")
	public ResponseEntity<?> getAllAccommodationBookings()
	{
		System.out.println("Get All Accommodation Bookings");
		return ResponseEntity.ok(accoService.getAllAccommodationBookings());
	}

	
}
