package com.app.entities;

import java.time.*;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "Pooja")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pooja extends BaseEntity{
	
	
	
	@Column(name = "pooja_date")
	private LocalDate date;
	
	@Column(name = "no_of_person")
	private int noOfPerson;
	
	
	private double amount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="pooja_type")
	private PoojaType pooja;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	

	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12,unique = true)
	private String adharNo;

}
