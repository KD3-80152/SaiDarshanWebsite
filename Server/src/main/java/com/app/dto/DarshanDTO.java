package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DarshanDTO {
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime timeSlot;
	
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
	
	private String primaryDevoteeName;
	@NotNull
	private String adharNo;

}
