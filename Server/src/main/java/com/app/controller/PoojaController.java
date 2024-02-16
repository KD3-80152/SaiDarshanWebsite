package com.app.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import com.app.entities.PoojaType;
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
		
		
	//GET ALL BOOKED DATES i.e. UNAVAILABLE DATES
	//method: GET
	// https://localhost:8443/pooja/get-booked-dates
		@GetMapping("/get-booked-dates")
		public List<LocalDate> getBookedDates()
		{
			return poojaService.getAllBookedDates();
		}
		
	//GET ALL BOOKED DATES i.e. UNAVAILABLE DATES
	//method: GET
	// https://localhost:8443/pooja/get-booked-dates/{date}
		@GetMapping("/get-booked-dates/{date}")
		public List<String> getBookedPoojaTypeForDate(@PathVariable String date)
		{
			System.out.println("date:" + date);
		        // Define the date formatter (optional, but recommended)
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		        try {
		            // Parse the string to LocalDate
		            LocalDate lDate = LocalDate.parse(date, formatter);
		         // Print the LocalDate
		            System.out.println("Parsed LocalDate: " + lDate);
		         // get the enum list to string list
		            List<PoojaType> list=poojaService.getBookedPoojaTypeForTheDate(lDate);
		            List<String> stringList= new ArrayList<String>();
		            for (PoojaType poojaType : list) {
						stringList.add(poojaType.toString());
					}
		           
		            return stringList;
		            
		        } catch (Exception e) {
		            // Handle parsing exception
		            System.out.println("Error parsing date: " + e.getMessage());
		            return null;
		        }
			
		}
		
}
