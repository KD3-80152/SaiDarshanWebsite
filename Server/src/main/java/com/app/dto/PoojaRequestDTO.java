package com.app.dto;

import java.time.*;

//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.app.entities.PoojaType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoojaRequestDTO {
	
	
	@NotNull
	private PoojaType pooja;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	@Range(max = 2)
	private int noofperson;
	
	@NotNull
	private double amount;
	

}
