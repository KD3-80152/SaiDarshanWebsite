package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Accommodation;

public interface AccommodationDao extends JpaRepository<Accommodation,Long>{
	List<Accommodation> findByUserId(Long userId);
	
	@Query("select a from Accommodation a order by a.checkInDate")
	List<Accommodation> findAllByOrderedByCheckInDateAsc();
}
