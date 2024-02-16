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

import com.app.dto.AccommodationRequestDTO;
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
	
	//ADD NEW ACCOMMODATION BOOKING
	//method=POST
	// http://host:port/accommodation/add
	@PostMapping("/add")
	public ResponseEntity<?> addAccommodationBooking(@RequestBody
			@Valid AccommodationRequestDTO acco) {
		System.out.println("in add accommodation " + acco);
		Long userId = authUserDetails.getUserId();
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(accoService.addAccomodationBooking(acco,userId));
	}
	
	//GET PARTICULAR USER'S ACCOMMODATION BOOKINGS
	//method=GET
	// http://host:port/accommodation/
	@GetMapping(value = "/")
	public ResponseEntity<?> getAccommodationBookingsByUser() throws IOException {
		Long userId = authUserDetails.getUserId();
		System.out.println("get accommodation bookings by user " + userId);
		return ResponseEntity.ok(accoService.getAllAccommodationBookingsByUserId(userId));
	}
	
	//CANCEL PARTICULAR USER'S ACCOMMODATION BOOKINGS
	//method=DELETE
		// http://host:port/accommodation/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccommodationDetails(@PathVariable Long id) {
		System.out.println("in update accommodation" + id);
		return ResponseEntity.ok(accoService.deleteAccomodationBookingById(id));
	}
	
	


//	//ADMIN POV GETTING ALL ACCOMMODATION BOOKINGS
//			//method=GET
//			// http://host:port/accommodation/all
//	@GetMapping("/all")
//	public ResponseEntity<?> getAllAccommodationBookings()
//	{
//		System.out.println("Get All Accommodation Bookings");
//		return ResponseEntity.ok(accoService.getAllAccommodationBookings());
//	}
	
	
	
	@GetMapping("/booked-dates")
	public ResponseEntity<?> getAllAvailableDates()
	{
		System.out.println("Get All booked Accommodation Dates");
		return ResponseEntity.ok(accoService.getAllBookedDates());
	}

	
}
