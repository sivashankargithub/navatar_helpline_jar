package pkg1.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="services")
public class ServicesEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String service_name;

	@OneToMany(mappedBy = "service1")
	private List<ServiceProviderEntity> spe1;
	@OneToMany(mappedBy = "service2")
	private List<ServiceProviderEntity> spe2;
	@OneToMany(mappedBy = "service3")
	private List<ServiceProviderEntity> spe3;
	@OneToMany(mappedBy = "servicesEntity")
	private List<AppointmentEntity> appointmentEntity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public ServicesEntity() {
		super();
	}
	public ServicesEntity(long id, String service_name) {
		super();
		this.id = id;
		this.service_name = service_name;
	}
}
