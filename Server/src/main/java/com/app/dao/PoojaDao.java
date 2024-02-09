package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Pooja;

public interface PoojaDao extends JpaRepository<Pooja, Long> {
	
	List<Pooja> findByUserId(Long userId);

}
