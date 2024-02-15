package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AccommodationDao;
import com.app.dao.UserEntityDao;
import com.app.dto.AccommodationRequestDTO;
import com.app.dto.AccommodationResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Accommodation;
import com.app.entities.UserEntity;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {
	@Autowired
	private AccommodationDao accodao;
	
	@Autowired
	private UserEntityDao userDao; 
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public ApiResponse addAccomodationBooking(AccommodationRequestDTO acco,Long userId) {
	    UserEntity curUser = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User"));
		Accommodation accoEntity = mapper.map(acco,Accommodation.class);
		accoEntity.setUser(curUser);
		accoEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		accoEntity.setAdharNo(curUser.getAdharNumber());
		Accommodation persistentAcco = accodao.save(accoEntity);
	    incrementCounter(persistentAcco);
	    if(persistentAcco.getRoomCounter()==3)
			return new ApiResponse("No booking avilable on given date");
		return new ApiResponse("Room booking successfully done.");

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
		decrementCounter(acco);
		return new ApiResponse("Accommodation Details of accommodation with Id" + acco.getId() + " deleted....");
		
	}
	
	
	@Override
	public List<AccommodationResponseDTO> getAllAccommodationBookings() {
		
		
		List<Accommodation> sortedListByCheckInDate = accodao.findAllByOrderedByCheckInDateAsc();
		return sortedListByCheckInDate.stream()
				.map(accommodation -> mapper.map(accommodation, AccommodationResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LocalDate> getAllAvailableDates() {
		return accodao.findCheckInDatesByRoomCounter();
	}

	@Override
	public Integer incrementCounter(Accommodation acco) {
		List<Accommodation> accoList = accodao.findByCheckInDate(acco.getCheckInDate());
		if(accoList!=null) {
		Accommodation ac = accoList.get(0);
		//accoList.forEach(a -> a.setRoomCounter(ac.getRoomCounter()+a.getNumberOfRooms()));
		accoList.forEach(a -> a.setRoomCounter(a.getRoomCounter()+1));
		return ac.getRoomCounter();
		}
		else 
			acco.setRoomCounter(1);
		return acco.getRoomCounter();
		
	}
	
	@Override
	public Integer decrementCounter(Accommodation acco) {
		List<Accommodation> accoList = accodao.findByCheckInDate(acco.getCheckInDate());
		Accommodation ac = accoList.get(0);
		//accoList.forEach(a -> a.setRoomCounter(a.getRoomCounter()-acco.getNumberOfRooms()));
		accoList.forEach(a -> a.setRoomCounter(a.getRoomCounter()-1));
		return ac.getRoomCounter();
		
	}

}
