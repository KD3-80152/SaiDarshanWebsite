package com.app.service;

import java.util.List;

import com.app.entities.BookingDate;
import com.app.entities.TimeSlot;

public interface BookingDateService {
	
	List<BookingDate> getAllBookingDates();
	BookingDate saveBookingDate(BookingDate bookingDate);	
	
}
