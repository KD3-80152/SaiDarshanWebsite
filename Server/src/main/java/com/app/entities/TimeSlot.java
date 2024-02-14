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
@Entity(name="time_slots")
public class TimeSlot extends BaseEntity {
	
	@Column(name="darshan_time_slot")
	@Enumerated(EnumType.STRING) 
    private TimeEnum darshanTimeSlot;
	
	
	@OneToMany(mappedBy = "timeSlot")
	@JoinColumn(name = "darshan_id")
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
