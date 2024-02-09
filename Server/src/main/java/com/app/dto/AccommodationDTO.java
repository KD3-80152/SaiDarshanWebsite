package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccommodationDTO {
	@NotNull
	@Range(max=2)
	private int numberOfDays;
	
	@NotNull
	private LocalDate checkInDate;
	
	@NotNull
	private LocalTime checkInTime;
	
	@NotNull
	@Range(max=2)
	private int numberOfRooms;
}
