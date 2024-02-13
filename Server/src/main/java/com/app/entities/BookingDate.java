package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_date")
@NoArgsConstructor
@AllArgsConstructor
public class BookingDate extends BaseEntity {
	
	@Column(name = "darshan_date")
    private LocalDate darshanDate;
    
	@Column(name = "is_darshan_available")
    private boolean isDarshanAvailable;
    
    @OneToMany(mappedBy = "bookingDate")
	private List<Darshan> darshanList;
    
    public Long addDarshan(Darshan darshan) {
		darshanList.add(darshan);
		darshan.setBookingDate(this);
		return this.getId();
	}
	public void removeDarshan(Darshan darshan) {
		darshanList.remove(darshan);
		darshan.setBookingDate(null);
	}
	
    
   // private int darshanCounter;
    
//    
//    @OneToMany(mappedBy = "bookingDate")
//    private List<TimeSlot> timeSlots;
//    
    

}
