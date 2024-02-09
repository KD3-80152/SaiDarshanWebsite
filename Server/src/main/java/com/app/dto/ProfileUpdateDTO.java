package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.app.entities.Address;
import com.app.entities.State;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class ProfileUpdateDTO {

	@JsonProperty(access = Access.READ_ONLY) // this property only used during ser.
	private Long id;
	
	@NotBlank(message = "First Name required")
	private String firstName;
	
	private String lastName;
	@Email(message = "Invalid Email!!!")
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password format")
	private String password;
	
	@NotBlank(message = "Please enter your mobile number in order to proceed!")
	@Pattern(regexp="^\\d{10}$",message = "Invalid number :(")
	private String mobileNo;
	
	private UserRole role;
	
//	@NotBlank(message= "Please enter your address " )
//	private Address address;
	
	@NotBlank(message="This field can't be empty")
	private String lineOne;
	
	
	private String lineTwo;
	
	
	private String country;
	
	@NotBlank(message="This field can't be empty")
	private String pincode;
	
	
	private State state;
	
	@NotBlank(message="This field can't be empty")
	private String district;
	
	
	
	
	
	
	
		
	
	
	
	
}
