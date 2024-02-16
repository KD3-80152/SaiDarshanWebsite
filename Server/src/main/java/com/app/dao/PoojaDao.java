package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Pooja;
import com.app.entities.PoojaType;

public interface PoojaDao extends JpaRepository<Pooja, Long> {
	
	List<Pooja> findByUserId(Long userId);

	List<Pooja> findByDateAndPooja(LocalDate date,PoojaType pooja);

	@Query("select p from Pooja p where p.date:date group by p.pooja having sum(p.noOfPerson)>= 4")
	List<PoojaType> findPoojaTypeByDate(LocalDate date);
	
	@Query("select p from Pooja p group by p.date having sum(p.noOfPerson) >= 8 ")
	List<LocalDate> findAllBookedDatesByNoOfPerson();
 }
