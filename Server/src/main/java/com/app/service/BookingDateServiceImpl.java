package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookingDateDao;
import com.app.dao.TimeSlotDao;
import com.app.entities.BookingDate;
@Service
@Transactional
public class BookingDateServiceImpl implements BookingDateService {
	
	@Autowired
    private BookingDateDao bookingDateDao;
	
	@Override
	public List<BookingDate> getAllBookingDates() {
		 return bookingDateDao.findAll();
	}

	@Override
	public BookingDate saveBookingDate(BookingDate bookingDate) {
		// TODO Auto-generated method stub
		return bookingDateDao.save(bookingDate);
	}

}
