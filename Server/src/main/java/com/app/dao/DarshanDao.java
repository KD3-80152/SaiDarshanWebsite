package com.app.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.Darshan;

public interface DarshanDao extends JpaRepository<Darshan, Long> {
	
	List<Darshan> findByUserId(Long userId);
	

	//@Query("select d from Darshan d where d.bookingDate=:bookingDate and d.timeSlot = :timeSlot")
	List<Darshan> findByBookingDateAndTimeSlot(Long bookingDateId , Long TimeSlotId);


//	@Query("select d from Darshan d order by d.date
//	List<Darshan> findAllOrderedByDateAsc();

	
}
