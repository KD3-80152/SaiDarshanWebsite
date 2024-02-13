package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PoojaDTO;
import com.app.dto.PoojaRequestDTO;
import com.app.dto.PoojaResponseDTO;

public interface PoojaService {
	
	PoojaResponseDTO addPoojaBooking(PoojaRequestDTO darshan,Long userId);
	
	List<PoojaResponseDTO> getAllPoojaBookingsByUserId(Long poojaId);

	ApiResponse deletePoojaBookingById(Long poojaId);

	List<PoojaResponseDTO> getAllPoojaBookings();

}
