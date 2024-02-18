package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DarshanResponseDTO 
{	
	@NotNull
	private LocalDate bookingDate;
	
	@NotNull
	private String timeSlot;
	
	@NotNull
	@Range(max=4)
	private int persons;

//	@NotNull
//	@Range(max=4)
//	private int women;
//	
//	@NotNull
//	@Range(max=4)
//	private int children;
	@NotNull
	private double amount;
	
	private String primaryDevoteeName;
	
	@NotNull
	private String adharNo;
	
	
}
