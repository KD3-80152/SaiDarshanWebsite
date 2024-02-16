
package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Darshan;
import com.app.entities.TimeEnum;
import com.app.entities.TimeSlot;

public interface DarshanDao extends JpaRepository<Darshan, Long> {
	
	List<Darshan> findByUserId(Long userId);
	
	List<Darshan> findByBookingDateAndTimeSlot(LocalDate date,TimeEnum timeSlot);

	//@Query("select d from Darshan d where d.bookingDate=:bookingDate and d.timeSlot = :timeSlot")
	List<Darshan> findByBookingDateAndTimeSlot(Long bookingDateId , Long TimeSlotId);
	
	/*@Query("select d.timeSlot from Darshan d where d.bookingDate = :date group by a.timeSlot having sum(d.persons)>=5")
	List<TimeEnum> findAllTimeSlotsByBookingDate(LocalDate date);*/

//	@Query("select d from Darshan d order by d.date
//	List<Darshan> findAllOrderedByDateAsc();

	@Query("select d.bookingDate from Darshan d group by d.bookingDate having sum(d.persons)>=30")
	List<LocalDate> findAllBookingDatesByPersons();
	
//	@Query("select new com.app.entities.Darshan( d.timeSlot) from Darshan d where d.bookingDate = :date and d.counter < 5" )
//	List<TimeSlot> FindTimeSlotsByBookingDateAndCounter(LocalDate date);
}
