package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Accommodation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccommodationDaoTest 
{
	@Autowired
	private AccommodationDao accommodationDao;
	
	@Test
	void testAddAccommdation()
	{
		List<Accommodation> list = List.of(
				new Accommodation(2, LocalDate.parse("2024-03-10"), LocalTime.parse("12:00:00"), 1, "Unnati Joshi", "146372983563", 400),
				new Accommodation(1, LocalDate.parse("2024-03-12"), LocalTime.parse("11:00:00"), 1, "Mugdha Moghe", "146372983562", 200),
				new Accommodation(2, LocalDate.parse("2024-03-15"), LocalTime.parse("12:00:00"), 2, "Himanshu Rathore", "146372983567", 400));
		
		List<Accommodation> list2 = accommodationDao.saveAll(list);
		assertEquals(3, list2.size());
		
	}
}
