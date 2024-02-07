package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.app.entities.Address;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Signup {
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
	
	@NotBlank(message = "Please enter your address!")
	private Address address;
	
	
	
	public Signup(String firstName, String lastName,
			String email, String password, UserRole role,Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address=address;
	}
	
	
}