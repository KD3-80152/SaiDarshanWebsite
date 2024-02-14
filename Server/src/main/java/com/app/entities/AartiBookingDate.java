package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "Aarti_booking_date")
@NoArgsConstructor
@AllArgsConstructor
public class AartiBookingDate extends BaseEntity {

	@Column(name = "aarti_date")
    private LocalDate aartiDate;
    
    @OneToMany(mappedBy = "aartiBookingDate")
    @JoinColumn(name = "aarti_id")
	private List<Aarti> aartiList;
    
    public Long addAarti(Aarti aarti) {
		aartiList.add(aarti);
		aarti.setAartiBookingDate(this);
		return this.getId();
	}

    
	public void removeAarti(Aarti aarti) {
		aartiList.add(aarti);
		aarti.setAartiBookingDate(null);
	}
}
