package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aarti extends BaseEntity
{
	@Column(name = "arti_date")
	private LocalDate aDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "aarti_type",length = 20 )
	private AartiType type;
	
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
	
}
