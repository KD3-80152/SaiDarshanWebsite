package com.app.service;

import java.util.List;

import com.app.dto.PoojaDTO;

public interface PoojaService {
	
	PoojaDTO addPoojaBooking(PoojaDTO darshan);
	
	List<PoojaDTO> getAllPoojaBookingsByUserId(Long poojaId);

	String deletePoojaBookingById(Long poojaId);

}
