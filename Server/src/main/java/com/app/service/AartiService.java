package com.app.service;

import java.util.List;

import com.app.dto.AartiDTO;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;

public interface AartiService 
{
	AartiDTO addAartiBooking(AartiDTO aarti,Long userId);
	
	List<AartiDTO> getAllAartiBookingsByUserId(Long userId);
	
	ApiResponse deleteAartiBookingById(Long id);
}
