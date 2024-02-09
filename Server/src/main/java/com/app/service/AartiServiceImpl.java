package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.AartiDao;
import com.app.dto.AartiDTO;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;
import com.app.entities.Aarti;
import com.app.entities.Darshan;


@Service
@Transactional
public class AartiServiceImpl implements AartiService 
{
	@Autowired
	private AartiDao aartiDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public AartiDTO addAartiBooking(AartiDTO aarti) {
		// TODO Auto-generated method stub
		Aarti artiEnt = mapper.map(aarti, Aarti.class);
		Aarti persistentEnt = aartiDao.save(artiEnt);
			
		return mapper.map(persistentEnt, AartiDTO.class);
	}

	@Override
	public List<AartiDTO> getAllAartiBookingsByUserId(Long aartiId) {
		// TODO Auto-generated method stub
		List<Aarti> aartiList = aartiDao.findByUserId(aartiId);
		return aartiList.stream().map(aarti -> mapper.map(aarti, AartiDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteAartiBookingById(Long id) {
		// TODO Auto-generated method stub
		
		Aarti aarti = aartiDao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		aartiDao.delete(aarti);
		return new ApiResponse("Darshan Details of dasrhan with ID " + aarti.getId() + " deleted....");
//		return null;
	}
	
}
