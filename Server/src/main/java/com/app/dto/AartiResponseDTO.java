package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.app.entities.AartiType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class AartiResponseDTO 
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
	
	@NotBlank
	@NotNull
	private String primaryDevoteeName;
	
	@NotBlank
	@NotNull
	private String adharNo;
	
	private Long id;
}
