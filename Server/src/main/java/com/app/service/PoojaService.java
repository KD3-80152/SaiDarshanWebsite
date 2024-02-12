package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PoojaDTO;

public interface PoojaService {
	
	PoojaDTO addPoojaBooking(PoojaDTO darshan,Long userId);
	
	List<PoojaDTO> getAllPoojaBookingsByUserId(Long poojaId);

	ApiResponse deletePoojaBookingById(Long poojaId);

	List<PoojaDTO> getAllPoojaBookings();

}
