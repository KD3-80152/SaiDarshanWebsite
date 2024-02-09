package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Darshan extends BaseEntity
{
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
	@Column(name= "adhar_no",unique=true)
	private String adharNo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_id") // Optional BUT reco , to specify the name of FK col.
	private UserEntity user;
	
}
