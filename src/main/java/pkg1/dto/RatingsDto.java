package pkg1.dto;

import pkg1.entity.RatingsEntity;

public class RatingsDto {
	private long appointment_id;
	private RatingsEntity ratings;
	
	public RatingsDto(long appointment_id, RatingsEntity ratings) {
		super();
		this.appointment_id = appointment_id;
		this.ratings = ratings;
	}
	public RatingsDto() {
		super();
	}
	public long getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(long appointment_id) {
		this.appointment_id = appointment_id;
	}
	public RatingsEntity getRatings() {
		return ratings;
	}
	public void setRatings(RatingsEntity ratings) {
		this.ratings = ratings;
	}

}
