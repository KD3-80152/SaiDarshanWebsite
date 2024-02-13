package com.app.service;

import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.DarshanDao;
import com.app.dao.TimeSlotDao;
import com.app.dto.ApiResponse;
import com.app.dto.DarshanDTO;
import com.app.entities.BookingDate;
import com.app.entities.Darshan;
import com.app.entities.TimeSlot;
@Service
@Transactional

public class DarshanServiceImpl implements DarshanService {
	

	@Autowired
	private DarshanDao darshanDao;
	
	@Autowired
	private TimeSlotDao timeSlotDao;
	
	@Autowired
	private BookingDate bookingDate;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public DarshanDTO addDarshanBooking(DarshanDTO darshanDTO) {
		Darshan darshanEntity=  mapper.map(darshanDTO, Darshan.class);
		TimeSlot timeSlot = mapper.map(darshanDTO,TimeSlot.class);
		BookingDate bookingDate = mapper.map(darshanDTO, BookingDate.class);
		Darshan persistentDarshan = darshanDao.save(darshanEntity);
		Long tId = timeSlot.addDarshan(persistentDarshan);
		Long dId = bookingDate.addDarshan(persistentDarshan);
		Integer counter = incrementCounter(tId, dId);
		if(counter==5)
			return null;
		return mapper.map(persistentDarshan, DarshanDTO.class);

	}

	@Override
	public List<DarshanDTO> getAllDarshanBookingsByUserId(Long darshanId) { 
	
		List<Darshan> darshanList = darshanDao.findByUserId(darshanId);
		return darshanList.stream().map(darshan -> mapper.map(darshan, DarshanDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ApiResponse deleteDarshanBookingById(Long id) {

		Darshan darshan = darshanDao.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		
		darshanDao.delete(darshan);
		return new ApiResponse("Darshan Details of dasrhan with ID " + darshan.getId() + " deleted....");
		

	}

	@Override
	public Integer incrementCounter(Long timeSlotId, Long bookingDateId) {
		List<Darshan> darshanList = darshanDao.findByBookingDateAndTimeSlot(bookingDateId, timeSlotId);
		Darshan d = darshanList.get(0);
		if(d.counter == null)
			darshanList.stream().map(darshan -> darshan.counter = 0);
		    darshanList.stream().map(darshan -> darshan.counter ++);
		return d.counter;
	}

	

}
