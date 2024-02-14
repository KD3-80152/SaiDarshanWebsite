package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class DarshanRequestDTO 
{
	@NotNull
	private LocalDate date;
	
	@NotNull
	private String timeSlot;
	
	@NotNull
	@Range(max=4)
	private int men;

	@NotNull
	@Range(max=4)
	private int women;
	
	@NotNull
	@Range(max=4)
	private int children;
	
	@NotNull
	private float amount;
	
}
