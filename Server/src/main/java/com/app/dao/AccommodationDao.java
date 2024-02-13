package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Accommodation;

public interface AccommodationDao extends JpaRepository<Accommodation,Long>{
	List<Accommodation> findByUserId(Long userId);
	

	@Query("SELECT a FROM Accommodation a ORDER BY a.checkInDate ASC")
	List<Accommodation> findAllByOrderedByCheckInDateAsc();
}
