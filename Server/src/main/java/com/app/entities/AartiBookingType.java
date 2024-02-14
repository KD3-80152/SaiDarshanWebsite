package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="aarti_booking_type")
public class AartiBookingType extends BaseEntity{
	
	@Column(name="aarti_type")
	@Enumerated(EnumType.STRING) 
    private AartiType aartiEnumType;
	
	
	@OneToMany(mappedBy = "aartiBookingType")
	@JoinColumn(name = "aarti_id")
	private List<Aarti> aartiList;
	
	
    public Long addAarti(Aarti aarti) {
			aartiList.add(aarti);
			aarti.setAartiBookingtype(this);
			return this.getId();
		}
	 
	public void removeAarti(Aarti aarti) {
			aartiList.remove(aarti);
			aarti.setAartiBookingtype(null);
	   }
}
