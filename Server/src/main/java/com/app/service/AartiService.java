package com.app.service;

import java.util.List;

import com.app.dto.AartiDTO;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;

public interface AartiService 
{
	AartiDTO addAartiBooking(AartiDTO aarti);
	List<AartiDTO> getAllAartiBookingsByUserId(Long aartiId);
	ApiResponse deleteAartiBookingById(Long id);
	List<AartiDTO> getAllAartiBookings();
}
