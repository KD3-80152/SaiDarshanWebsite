package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.DarshanDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;
import com.app.entities.Darshan;
import com.app.entities.UserEntity;
@Service
@Transactional

public class DarshanServiceImpl implements DarshanService {
	

	@Autowired
	private DarshanDao darshanDao;
	
	@Autowired
	private UserEntityDao userDao; 
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public DarshanDTO addDarshanBooking(DarshanDTO darshan,Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Inavalid userId"));
		Darshan darshanEntity=  mapper.map(darshan, Darshan.class);
		darshanEntity.setUser(curUser);
		darshanEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		darshanEntity.setAdharNo(curUser.getAdharNumber());
		Darshan persistentDarshan = darshanDao.save(darshanEntity);
		return mapper.map(persistentDarshan, DarshanDTO.class);

	}

	@Override
	public List<DarshanDTO> getAllDarshanBookingsByUserId(Long userId) {
	
		List<Darshan> darshanList = darshanDao.findByUserId(userId);
		return darshanList.stream().map(darshan -> mapper.map(darshan, DarshanDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteDarshanBookingById(Long darshanId) {

		
		Darshan darshan = darshanDao.findById(darshanId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid darshan id"));
		
		
		LocalDate currentDate = LocalDate.now();
		
		long differenceInDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, darshan.getDate());

		if(differenceInDays >= 15)
		{
			darshanDao.delete(darshan);
			return new ApiResponse("Darshan Details of dasrhan with ID " + darshan.getId() + " cancelled....");
		}
		
		else 
			return new ApiResponse("Darshan can't be cancelled as the buffer limit of 15 days has crossed....");
			
	}

	
	

}
