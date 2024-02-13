package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.BookingDate;
import com.app.entities.Darshan;
import com.app.entities.TimeSlot;

public interface DarshanDao extends JpaRepository<Darshan, Long> {
	
	List<Darshan> findByUserId(Long userId);
	

	//@Query("select d from Darshan d where d.bookingDate=:bookingDate and d.timeSlot = :timeSlot")
	List<Darshan> findByBookingDateAndTimeSlot(Long bookingDateId , Long TimeSlotId);


	List<Darshan> findAllOrderedByDateAsc();

	
}
