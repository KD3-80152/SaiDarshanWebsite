package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;

public interface DarshanService {
	
	DarshanDTO addDarshanBooking(DarshanDTO darshan);
	
	List<DarshanDTO> getAllDarshanBookingsByUserId(Long darshanId);
	
	ApiResponse deleteDarshanBookingById(Long id);

	List<DarshanDTO> getAllDarshanBookings();

}

