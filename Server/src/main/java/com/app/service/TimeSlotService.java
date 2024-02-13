package com.app.service;

import java.util.List;

import com.app.dto.DarshanDTO;
import com.app.entities.TimeSlot;

public interface TimeSlotService {
	
	List<TimeSlot> getAllTimeSlots();
	TimeSlot saveTimeSlot(TimeSlot timeslot);
	//void incrementCounter(Long timeSlotId);
}
