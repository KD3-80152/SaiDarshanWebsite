package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DarshanDTO {
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime timeSlot;
	
//	@NotNull
//	@Range(max=4)
//	private int men;

//	@NotNull
//	@Range(max=4)
//	private int women;

//	@NotNull
//	@Range(max=4)
//	private int children;
	
	@Range(max=4)
	private int noofPerson;
		
	
	
	@NotNull
	private float amount;
	
	private String primaryDevoteeName;
	
	@NotNull
	private String adharNo;
	
	@JsonProperty(access = Access.READ_ONLY)
	public Integer counter;

}
