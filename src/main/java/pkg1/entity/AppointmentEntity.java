package pkg1.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pkg1.enums.Connect;

@Entity
@Table(name="appointment")
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private CustomersEntity customerEntity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_id")
	private ServicesEntity servicesEntity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_provider_id")
	private ServiceProviderEntity serviceProviderEntity;
	
	private LocalDateTime appointment_date_time;
	private String issue;
	@Enumerated(EnumType.STRING)
	private Connect connect;
	@Column(columnDefinition = "tinyint(1) default 0")
	private int work_status;
	private String payment_id;
	@Column(columnDefinition = "tinyint(1) default 0")
	private int payment_satus;
	private LocalDateTime payment_date;
	@Column(name = "record_created_on")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "record_updated_on")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public AppointmentEntity() {
		super();
	}

	public AppointmentEntity(long id, CustomersEntity customerEntity, ServicesEntity servicesEntity,
			ServiceProviderEntity serviceProviderEntity, LocalDateTime appointment_date_time, String issue,
			Connect connect, int work_status, String payment_id, int payment_satus, LocalDateTime payment_date,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.customerEntity = customerEntity;
		this.servicesEntity = servicesEntity;
		this.serviceProviderEntity = serviceProviderEntity;
		this.appointment_date_time = appointment_date_time;
		this.issue = issue;
		this.connect = connect;
		this.work_status = work_status;
		this.payment_id = payment_id;
		this.payment_satus = payment_satus;
		this.payment_date = payment_date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	

	public AppointmentEntity(long id, LocalDateTime appointment_date_time, String issue, Connect connect,
			int work_status, String payment_id, int payment_satus, LocalDateTime payment_date, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.appointment_date_time = appointment_date_time;
		this.issue = issue;
		this.connect = connect;
		this.work_status = work_status;
		this.payment_id = payment_id;
		this.payment_satus = payment_satus;
		this.payment_date = payment_date;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomersEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomersEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public ServicesEntity getServicesEntity() {
		return servicesEntity;
	}

	public void setServicesEntity(ServicesEntity servicesEntity) {
		this.servicesEntity = servicesEntity;
	}

	public ServiceProviderEntity getServiceProviderEntity() {
		return serviceProviderEntity;
	}

	public void setServiceProviderEntity(ServiceProviderEntity serviceProviderEntity) {
		this.serviceProviderEntity = serviceProviderEntity;
	}

	public LocalDateTime getAppointment_date_time() {
		return appointment_date_time;
	}

	public void setAppointment_date_time(LocalDateTime appointment_date_time) {
		this.appointment_date_time = appointment_date_time;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Connect getConnect() {
		return connect;
	}

	public void setConnect(Connect connect) {
		this.connect = connect;
	}

	public int getWork_status() {
		return work_status;
	}

	public void setWork_status(int work_status) {
		this.work_status = work_status;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public int getPayment_satus() {
		return payment_satus;
	}

	public void setPayment_satus(int payment_satus) {
		this.payment_satus = payment_satus;
	}

	public LocalDateTime getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDateTime payment_date) {
		this.payment_date = payment_date;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
