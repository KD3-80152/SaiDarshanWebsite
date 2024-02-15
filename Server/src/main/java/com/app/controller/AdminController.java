package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.FindUserDetails;
import com.app.service.AartiService;
import com.app.service.AccommodationService;
import com.app.service.DarshanService;
import com.app.service.PoojaService;
import com.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FindUserDetails authUserDetails;
	
	@Autowired
	private PoojaService poojaService;
	
	@Autowired
	private AccommodationService accoService;
	
	@Autowired
	private DarshanService darshanService;
	
	@Autowired
	private AartiService artiService;
	
	
	//ADMIN POV GET ALL USERS
			//method=get
			// http://host:port/signin/user
			@GetMapping("/all-users")
			public ResponseEntity<?> getAllUsers()
			{
				System.out.println("in get all users admin pov");
				return ResponseEntity.ok(userService.getAllUsers());
			}
			
			
			//ADMIN POV DELETE USER BY ID
			//method=delete
			// http://host:port/signin/user/{id}
				
				@DeleteMapping("/all-users/{id}")

				public ResponseEntity<?> deleteUser(@PathVariable Long userId)

				{
					Long adminId = authUserDetails.getUserId();
					System.out.println("in delete user " + userId + " ");
					return ResponseEntity.ok(userService.deleteUserDetails(userId));
				}
				
				
				
				
				//ADMIN POV GETTING ALL POOJA BOOKINGS
				//method=GET
				// http://host:port/pooja/all
				@GetMapping("/allPooja")
				public ResponseEntity<?> getAllPoojaBookings() throws IOException 
				{
					
					System.out.println("get Pooja bookings");
					return ResponseEntity.ok(poojaService.getAllPoojaBookings());
					
				}
				
				
				//ADMIN POV GETTING ALL ACCOMMODATION BOOKINGS
				//method=GET
				// http://host:port/accommodation/all
				@GetMapping("/allAccommodation")
				public ResponseEntity<?> getAllAccommodationBookings()
				{
					System.out.println("Get All Accommodation Bookings");
					return ResponseEntity.ok(accoService.getAllAccommodationBookings());
				}
				
				
				//ADMIN POV GETTING ALL DARSHAN BOOKINGS
				//method=GET
						// http://host:port/darshan/all
				@GetMapping("/allDarshan")
				public ResponseEntity<?> getAllDarshanBookings()
				{
					System.out.println("Get All Darshan Bookings");
					return ResponseEntity.ok(darshanService.getAllDarshanBookings());
				}
				
				
				//ADMIN POV GETTING ALL AARTI BOOKINGS
				//method=GET
				// http://host:port/aarti/all
				@GetMapping("/allAarti")
				public ResponseEntity<?> getAllAartiBookings()
				{
					System.out.println("Get All Aarti Bookings");
					return ResponseEntity.ok(artiService.getAllAartiBookings());
				}
				
	
	
}
