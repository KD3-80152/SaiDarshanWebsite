package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.FetchType;
>>>>>>> 554bf647d4352891f756fc67e102160b25f20ccf
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="darshan")
@Getter
@Setter
@ToString
<<<<<<< HEAD
public class Darshan extends BaseEntity {
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> e927ba8a4c68c633cf620dd303c2b942170ef08a
@Entity
@Table(name = "darshan")
public class Darshan extends BaseEntity{
	
<<<<<<< HEAD
=======
public class Darshan extends BaseEntity{
>>>>>>> prashant
=======

>>>>>>> e927ba8a4c68c633cf620dd303c2b942170ef08a
>>>>>>> 554bf647d4352891f756fc67e102160b25f20ccf
	@Column(name="darshan_date")
	private LocalDate date;
	
	@Column(name="darshan_time_slot")
	private LocalTime timeSlot;
	
	@Column(name="no_of_men")
	private int men;
	
	@Column(name="no_of_women")
	private int women;
	
	@Column(name="no_of_children")
	private int children;
	
	private float amount;
	
	@Column(name="primary_devotee_name")
	private String primaryDevoteeName;
	
<<<<<<< HEAD
	
=======
	@Column(name= "adhar_no",unique=true)
	private String adharNo;
>>>>>>> 554bf647d4352891f756fc67e102160b25f20ccf
	
	@ManyToOne
	@JoinColumn(name = "user_id") // Optional BUT reco , to specify the name of FK col.
	private UserEntity user;
	
}
