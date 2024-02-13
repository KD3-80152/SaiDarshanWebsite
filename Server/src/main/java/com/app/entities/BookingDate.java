package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "booking_date")
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
