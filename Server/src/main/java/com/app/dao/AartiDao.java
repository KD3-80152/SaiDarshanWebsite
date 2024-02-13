package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Aarti;

public interface AartiDao extends JpaRepository<Aarti, Long> 
{
	List<Aarti> findByUserId(Long userId);

	@Query("select a from Aarti a order by a.aDate")
	List<Aarti> findAllOrderedByADateAsc();
	
}
