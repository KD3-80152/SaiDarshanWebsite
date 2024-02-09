package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Accommodation;

public interface AccommodationDao extends JpaRepository<Accommodation,Long>{
	List<Accommodation> findByUserId(Long userId);
}
