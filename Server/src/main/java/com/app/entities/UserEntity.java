package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "secure_users")
@NoArgsConstructor
@AllArgsConstructor()
@Getter
@Setter
@ToString(exclude = "password") // toString excluding password
public class UserEntity extends BaseEntity {
	

@Column(name = "first_name" ,length = 20)
private String firstName;

@Column(name = "last_name" ,length = 20)
private String lastName;

@Column(length = 30, unique = true)
private String email;

@Column(length = 300, nullable = false)
private String password;

@Column(name = "mobile_no",length = 10,unique = true ,nullable = false)
private String mobileNo;

@Enumerated(EnumType.STRING)
@Column(length = 20)
private UserRole role;

@Column(name="birth_date")
private LocalDate dob;



@Column(name="gender",length=20)
private Gender gender;

@Column(name = "adhar_number",length = 12,unique = true,nullable = false)
private String adharNumber;

@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Darshan> darshanList =new ArrayList<Darshan>();

public UserEntity(String firstName, String lastName, String email, String password, String mobileNo, UserRole role,
		LocalDate dob, Gender gender, String adharNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.mobileNo = mobileNo;
	this.role = role;
	this.dob = dob;
	this.gender = gender;
	this.adharNumber = adharNumber;
}





}