package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AccommodationDao;
import com.app.dao.DarshanDao;
import com.app.dto.AccommodationDTO;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;
import com.app.entities.Accommodation;
import com.app.entities.Darshan;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationDao accodao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public AccommodationDTO addAccomodationBooking(AccommodationDTO acco) {
		Accommodation accoEntity = mapper.map(acco,Accommodation.class);
		Accommodation persistentAcco = accodao.save(accoEntity);
		return mapper.map(persistentAcco, AccommodationDTO.class);
	}

	@Override
	public List<AccommodationDTO> getAllAccommodationBookingsByUserId(Long accoId) {
		List<Accommodation> accoList = accodao.findByUserId(accoId);
		return accoList.stream().map(acco -> mapper.map(acco, AccommodationDTO.class)).collect(Collectors.toList());

	}

	@Override
	public ApiResponse deleteAccomodationBookingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}