package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="darshan")

@ToString

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Darshan extends BaseEntity{

	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name = "timeslot")
	private TimeEnum timeSlot;
	
	@Column(name="no_of_persons")
	private int persons;
	
//	@Column(name="no_of_women")
//	private int women;
//	
//	@Column(name="no_of_children")
//	private int children;
	
	private float amount;
	
	@Column(name="primary_devotee_name")
	private String primaryDevoteeName;
	

	@Column(name= "adhar_no")
	private String adharNo;

	@ManyToOne
	@JoinColumn(name = "user_id") // Optional BUT reco , to specify the name of FK col.
	private UserEntity user;
	
	//public Integer counter;
	
	public Darshan(TimeEnum timeSlot) {
		
		this.timeSlot = timeSlot;
	}

	public Darshan(LocalDate bookingDate) {
		
		this.bookingDate = bookingDate;
	}

	
}
