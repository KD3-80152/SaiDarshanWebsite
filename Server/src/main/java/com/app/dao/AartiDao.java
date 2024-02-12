package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Aarti;

public interface AartiDao extends JpaRepository<Aarti, Long> 
{
	List<Aarti> findByUserId(Long userId);

	List<Aarti> findAllOrderedByADateAsc();
	
}