package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;

import com.app.dto.PoojaDTO;

import lombok.Getter;
import lombok.Setter;


public interface PoojaService {
	
	
	
	PoojaDTO addPoojaBooking(PoojaDTO darshan);
	
	List<PoojaDTO> getAllPoojaBookingsByUserId(Long darshanId);
	
	ApiResponse deleteDarshanBookingById(Long id);
	
	

}
