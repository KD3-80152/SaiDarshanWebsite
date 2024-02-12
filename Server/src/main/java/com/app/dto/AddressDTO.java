package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.app.entities.State;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	@NotBlank(message="This field can't be empty")
	private String lineOne;
	
	
	private String lineTwo;
	
	
//	private String country = "BHARAT(India)";
	
	@NotBlank(message="This field can't be empty")
	private String pincode;
	
	
	private State state;
	
	@NotBlank(message="This field can't be empty")
	private String district;
	
	
	
}
