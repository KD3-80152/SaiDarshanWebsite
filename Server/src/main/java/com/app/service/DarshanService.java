package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;

public interface DarshanService {
	
	DarshanDTO addDarshanBooking(DarshanDTO darshan,Long userId);
	
	List<DarshanDTO> getAllDarshanBookingsByUserId(Long userId);
	
	ApiResponse deleteDarshanBookingById(Long id);

}

