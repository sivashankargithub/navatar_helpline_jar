package pkg1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class RatingsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int customer_rating;
	private String customer_description;
	private int service_provider_rating;
	private String service_provider_description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="appointment_id")
	private AppointmentEntity appointment;

	public RatingsEntity() {
		super();
	}

	public RatingsEntity(long id, int customer_rating, String customer_description, int service_provider_rating,
			String service_provider_description, AppointmentEntity appointment) {
		super();
		this.id = id;
		this.customer_rating = customer_rating;
		this.customer_description = customer_description;
		this.service_provider_rating = service_provider_rating;
		this.service_provider_description = service_provider_description;
		this.appointment = appointment;
	}
	

	public RatingsEntity(long id, int customer_rating, String customer_description, int service_provider_rating,
			String service_provider_description) {
		super();
		this.id = id;
		this.customer_rating = customer_rating;
		this.customer_description = customer_description;
		this.service_provider_rating = service_provider_rating;
		this.service_provider_description = service_provider_description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCustomer_rating() {
		return customer_rating;
	}

	public void setCustomer_rating(int customer_rating) {
		this.customer_rating = customer_rating;
	}

	public String getCustomer_description() {
		return customer_description;
	}

	public void setCustomer_description(String customer_description) {
		this.customer_description = customer_description;
	}

	public int getService_provider_rating() {
		return service_provider_rating;
	}

	public void setService_provider_rating(int service_provider_rating) {
		this.service_provider_rating = service_provider_rating;
	}

	public String getService_provider_description() {
		return service_provider_description;
	}

	public void setService_provider_description(String service_provider_description) {
		this.service_provider_description = service_provider_description;
	}

	public AppointmentEntity getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentEntity appointment) {
		this.appointment = appointment;
	}	
}
