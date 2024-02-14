package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aarti")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aarti extends BaseEntity
{
	
	@ManyToOne
	@JoinColumn(name = "arti_date_id")
	private AartiBookingDate aartiBookingDate;
	
	
	@ManyToOne
	@JoinColumn(name = "aarti_booking_id")
	private AartiBookingType aartiBookingType;
	
	@Column(name = "no_of_men")
	private int men;
	
	@Column(name = "no_of_women")
	private int women;
	
	private double amount;
	
	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12,unique = true)
	private String adharNo;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	

	public Integer counter;

	
}
