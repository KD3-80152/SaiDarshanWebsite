package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class DarshanRequestDTO 
{
	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotNull
	private LocalDate bookingDate;
	
	@NotNull
	private String timeSlot;
	
	@NotNull
	@Range(max=4)
	private int persons;


	
	@NotNull
	private float amount;
	
}
