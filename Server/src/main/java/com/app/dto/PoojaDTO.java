package com.app.dto;

import java.time.*;

import javax.validation.constraints.NotBlank;

import com.app.entities.PoojaType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoojaDTO {
	
	
	@NotBlank
	private PoojaType poojatype;
	
	@NotBlank
	private LocalDateTime date;
	
	@NotBlank
	private LocalDateTime slot;
	
	@NotBlank
	private int person;
	
	@NotBlank
	private double amount;
	

}
