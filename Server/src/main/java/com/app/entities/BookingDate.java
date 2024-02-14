package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity(name = "booking_date")
@NoArgsConstructor
@AllArgsConstructor
public class BookingDate extends BaseEntity {
	
	@Column(name = "darshan_date")
    private LocalDate darshanDate;
    
	
    
    @OneToMany(mappedBy = "bookingDate")
    @JoinColumn(name = "darshan_Id")
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
