package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanRequestDTO;
import com.app.dto.DarshanResponseDTO;

public interface DarshanService {
	
	DarshanResponseDTO addDarshanBooking(DarshanRequestDTO darshan,Long userId);
	
	List<DarshanResponseDTO> getAllDarshanBookingsByUserId(Long userId);
	
	ApiResponse deleteDarshanBookingById(Long id);

	List<DarshanResponseDTO> getAllDarshanBookings();

}

