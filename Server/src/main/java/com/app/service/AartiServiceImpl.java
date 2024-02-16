package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AartiDao;
import com.app.dao.UserEntityDao;
import com.app.dto.AartiRequestDTO;
import com.app.dto.AartiResponseDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Aarti;
import com.app.entities.UserEntity;


@Service
@Transactional
public class AartiServiceImpl implements AartiService 
{
	@Autowired
	private AartiDao aartiDao;
	
	@Autowired
	private UserEntityDao userDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addAartiBooking(AartiRequestDTO aarti,Long userId) {
		UserEntity curUser= userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid userId"));
		
		List<Aarti> list = aartiDao.findByAartiBookingDate(aarti.getAartiBookingDate());
		
//		int noOfAartiSlotsByDate = 
				
		
		Aarti artiEntity = mapper.map(aarti, Aarti.class);
		artiEntity.setUser(curUser);
		artiEntity.setPrimaryDevoteeName(curUser.getFirstName()+" "+curUser.getLastName());
		artiEntity.setAdharNo(curUser.getAdharNumber());
		
		Aarti persistentEnt = aartiDao.save(artiEntity);
			
		return new ApiResponse();
	}

	@Override
	public List<AartiResponseDTO> getAllAartiBookingsByUserId(Long userId) {
		
		List<Aarti> aartiList = aartiDao.findByUserId(userId);
		return aartiList.stream().map(aarti -> mapper.map(aarti, AartiResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteAartiBookingById(Long id) {	

		Aarti aarti = aartiDao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		aartiDao.delete(aarti);
		return new ApiResponse("Darshan Details of dasrhan with ID " + aarti.getId() + " deleted....");

	}
	
	@Override
	public List<AartiResponseDTO> getAllAartiBookings() {
		
		List<Aarti> aartiSortedList = aartiDao.findAllOrderedByADateAsc();
		return aartiSortedList.stream()
				.map(aarti -> mapper.map(aarti, AartiResponseDTO.class))
				.collect(Collectors.toList());

	}
	
}





