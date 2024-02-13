package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.TimeSlot;

public interface TimeSlotDao extends JpaRepository<TimeSlot, Long> {

}
