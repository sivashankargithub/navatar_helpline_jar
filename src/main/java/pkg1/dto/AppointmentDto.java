package pkg1.dto;

import pkg1.entity.AppointmentEntity;

public class AppointmentDto {
	private long customer_id;
	private long service_id;
	private long service_provider_id;
	private AppointmentEntity appointment;
	
	public AppointmentDto(long customer_id, long service_id, long service_provider_id, AppointmentEntity appointment) {
		super();
		this.customer_id = customer_id;
		this.service_id = service_id;
		this.service_provider_id = service_provider_id;
		this.appointment = appointment;
	}
	public AppointmentDto() {
		super();
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public long getService_id() {
		return service_id;
	}
	public void setService_id(long service_id) {
		this.service_id = service_id;
	}
	public long getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(long service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	public AppointmentEntity getAppointment() {
		return appointment;
	}
	public void setAppointment(AppointmentEntity appointment) {
		this.appointment = appointment;
	}
}
