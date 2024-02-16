package com.app.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.app.entities.AartiType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class AartiRequestDTO 
{
	@NotNull
	private LocalDate aartiBookingDate;
	
	@NotNull
	private AartiType aartiBookingType;
	
	@NotNull
	@Range(max = 4)
	private int noOfPerson;
	
	@NotNull
	private double amount;
}
