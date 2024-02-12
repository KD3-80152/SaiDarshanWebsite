package com.app.service;

import java.util.List;

import com.app.dto.AccommodationDTO;
import com.app.dto.ApiResponse;

public interface AccommodationService {
	AccommodationDTO addAccomodationBooking(AccommodationDTO acco,Long userId);
	
	List<AccommodationDTO> getAllAccommodationBookingsByUserId(Long userId);
	
	ApiResponse deleteAccomodationBookingById(Long id);
}
