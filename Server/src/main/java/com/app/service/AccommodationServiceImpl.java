package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AccommodationDao;
import com.app.dto.AccommodationRequestDTO;
import com.app.dto.AccommodationResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Accommodation;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationDao accodao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AccommodationResponseDTO addAccomodationBooking(AccommodationRequestDTO acco,Long userId) {
		Accommodation accoEntity = mapper.map(acco,Accommodation.class);
		Accommodation persistentAcco = accodao.save(accoEntity);
		return mapper.map(persistentAcco, AccommodationResponseDTO.class);
	}

	@Override
	public List<AccommodationResponseDTO> getAllAccommodationBookingsByUserId(Long userId) {
		
		List<Accommodation> accoList = accodao.findByUserId(userId);
		return accoList.stream().map(acco -> mapper.map(acco, AccommodationResponseDTO.class)).collect(Collectors.toList());

	}

	@Override
	public ApiResponse deleteAccomodationBookingById(Long id) {
		Accommodation acco = accodao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		accodao.delete(acco);
		return new ApiResponse("Accommodation Details of accommodation with Id" + acco.getId() + " deleted....");
		
	}
	
	
	@Override
	public List<AccommodationResponseDTO> getAllAccommodationBookings() {
		
		
		List<Accommodation> sortedListByCheckInDate = accodao.findAllByOrderedByCheckInDateAsc();
		return sortedListByCheckInDate.stream()
				.map(accommodation -> mapper.map(accommodation, AccommodationResponseDTO.class))
				.collect(Collectors.toList());
	}

}
