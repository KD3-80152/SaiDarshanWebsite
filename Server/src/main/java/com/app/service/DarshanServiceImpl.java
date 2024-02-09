package com.app.service;

import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DarshanDao;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;
import com.app.entities.Darshan;
@Service
@Transactional
public class DarshanServiceImpl implements DarshanService {
	
	
	@Autowired
	private DarshanDao darshanDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public DarshanDTO addDarshanBooking(DarshanDTO darshan) {
		Darshan darshanEntity=  mapper.map(darshan, Darshan.class);
		Darshan persistentDarshan = darshanDao.save(darshanEntity);
		return mapper.map(persistentDarshan, DarshanDTO.class);

		
	}

	@Override
	public List<DarshanDTO> getAllDarshanBookingsByUserId(Long darshanId) {
	
		List<Darshan> darshanList = darshanDao.findByUserId(darshanId);
		return darshanList.stream().map(darshan -> mapper.map(darshan, DarshanDTO.class)).collect(Collectors.toList());

	}

	@Override
	public ApiResponse deleteDarshanBookingById(Long id) {
		
		return null;
	}

	

}
