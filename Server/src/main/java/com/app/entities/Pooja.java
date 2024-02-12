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
	
	@Column(name = "Pooja_Time")
	private LocalDateTime slot;
	
	@Column(name = "Pooja_Date")
	private LocalDate date;
	
	@Column(name = "No_Of_Person")
	private int noofperson;
	
	@Column(name = "Amount")
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private PoojaType pooja;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@Column(name = "primary_devotee_name")
	private String primaryDevoteeName;
	
	@Column(name = "adhar_no",length = 12,unique = true)
	private String adharNo;

}
