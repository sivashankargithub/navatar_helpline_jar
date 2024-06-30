package pkg1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pkg1.enums.ServiceDays;

@Entity
@Table(name="service_timing")
public class ServiceTimingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private ServiceDays service_day;
	private String timings="";
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="service_provider_id",referencedColumnName = "id")
	private ServiceProviderEntity serviceProvider;

	public ServiceTimingEntity() {
		super();
	}

	public ServiceTimingEntity(long id, ServiceDays service_day, String timings,
			ServiceProviderEntity serviceProvider) {
		super();
		this.id = id;
		this.service_day = service_day;
		this.timings = timings;
		this.serviceProvider = serviceProvider;
	}
	
	public ServiceTimingEntity(long id, ServiceDays service_day, String timings) {
		super();
		this.id = id;
		this.service_day = service_day;
		this.timings = timings;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ServiceDays getService_day() {
		return service_day;
	}

	public void setService_day(ServiceDays service_day) {
		this.service_day = service_day;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public ServiceProviderEntity getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProviderEntity serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	
}
