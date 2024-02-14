package com.app.service;

import java.util.List;

import com.app.dto.AccommodationRequestDTO;
import com.app.dto.AccommodationResponseDTO;
import com.app.dto.ApiResponse;

public interface AccommodationService {
	AccommodationResponseDTO addAccomodationBooking(AccommodationRequestDTO acco,Long userId);
	
	List<AccommodationResponseDTO> getAllAccommodationBookingsByUserId(Long userId);
	
	ApiResponse deleteAccomodationBookingById(Long id);
	List<AccommodationResponseDTO> getAllAccommodationBookings();
}
