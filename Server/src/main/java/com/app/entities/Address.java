package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="address")
@Getter
@Setter
@ToString
public class Address extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "user_id",nullable=false)
	@MapsId
	private UserEntity user;
	
	@Column(name="add_line_one",length = 120)
	private String lineOne;
	
	@Column(name="add_line_two",length=120)
	private String lineTwo;
	
	@Getter
	@Setter(value = AccessLevel.NONE)
	@Column(name="country")
	private String country;
	
	@Column(name="pincode",length=7)
	private String pincode;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Column(name="district",length=20)
	private String district;
	
	

	public Address(UserEntity user, String lineOne, String lineTwo, String country, String pincode, State state,
			String district)
	{
		super();
		this.user = user;
		this.lineOne = lineOne;
		this.lineTwo = lineTwo;
		this.country = "India";
		this.pincode = pincode;
		this.state = state;
		this.district = district;
		
	}
	
	
	
	
	
	
}
