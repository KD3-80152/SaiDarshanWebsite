package com.app.entities;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="time_slots")
public class TimeSlot extends BaseEntity {
	
	@Column(name="darshan_time_slot")
	@Enumerated(EnumType.STRING) 
    private TimeEnum darshanTimeSlot;
	
    
	@Column(name="is_darshan_available")
    private boolean isDarshanAvailable;
	
	@OneToMany(mappedBy = "timeSlot")
	private List<Darshan> darshanList;
	
	
    public Long addDarshan(Darshan darshan) {
			darshanList.add(darshan);
			darshan.setTimeSlot(this);
			return this.getId();
		}
	 
	public void removeDarshan(Darshan darshan) {
			darshanList.remove(darshan);
			darshan.setTimeSlot(null);
	   }
//            
//    @ManyToOne
//    private BookingDate bookingDate;
    

//	public int getDarshanCounter() {
//		return darshanCounter;
//	}
//
//	public void setDarshanCounter(int darshanCounter) {
//		this.darshanCounter = darshanCounter;
//	}
//    
    
	
	
}
