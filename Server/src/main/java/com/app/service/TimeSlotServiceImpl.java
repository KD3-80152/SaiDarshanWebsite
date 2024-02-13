package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DarshanDao;
import com.app.dao.TimeSlotDao;
import com.app.dto.DarshanDTO;
import com.app.entities.Darshan;
import com.app.entities.TimeSlot;
@Service
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService{
	
    @Autowired
    private TimeSlotDao timeSlotDao;

    @Autowired 
    private DarshanDao darshanDao;
    
	@Override
	public TimeSlot saveTimeSlot(TimeSlot timeSlot) {
//		TimeSlot timeSlot=new TimeSlot();
//		Long darshanId=darshanDto.get
//		Darshan darshan=darshanDao.findById();
		return timeSlotDao.save(timeSlot);
		
	}


	@Override
	public List<TimeSlot> getAllTimeSlots() {
		// TODO Auto-generated method stub
		return timeSlotDao.findAll();
		
	}

//    public void incrementCounter(Long timeSlotId) {
//        TimeSlot timeSlot = timeSlotDao.findById(timeSlotId)
//                                              .orElseThrow(() -> new IllegalArgumentException("Invalid time slot ID"));
//        timeSlot.setDarshanCounter(timeSlot.getDarshanCounter() + 1);
//        timeSlotDao.save(timeSlot);
//    }

    // Other methods for CRUD operations and counter management

}
