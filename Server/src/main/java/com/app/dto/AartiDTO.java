package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.AartiType;

import lombok.Data;


@Data

public class AartiDTO 
{

	@NotNull
	private LocalDate aDate;
	
	@NotNull
	private AartiType type;
	
	@NotNull
	@Range(max = 4)
	private int men;
	
	@NotNull
	@Range(max = 4)
	private int women;
	
	@NotNull
	private double amount;
	
	@NotNull
	private String primaryDevoteeName;
	
	
	
}
