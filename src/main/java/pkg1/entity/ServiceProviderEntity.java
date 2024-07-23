package pkg1.entity;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pkg1.enums.Gender;

@Entity
@Table(name="service_provider")
public class ServiceProviderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String fname;
	private String lname;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String country_code;
	private String pincode;
	private String email;
	private String mobile;
	private String lang_known;
	private int fees;
	@Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
	private boolean is_active=false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service1_id")
	private ServicesEntity service1;
	private String service1_description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service2_id")
	private ServicesEntity service2;
	private String service2_description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service3_id")
	private ServicesEntity service3;
	private String service3_description;
	
	@OneToMany(mappedBy = "serviceProvider")
	private List<ServiceTimingEntity> serviceTimingEntity;
	
	@OneToMany(mappedBy = "serviceProviderEntity")
	private List<AppointmentEntity> appointmentEntity;
	
	public ServiceProviderEntity() {
		super();
	}
	
	public ServiceProviderEntity(long id, String fname, String lname, Gender gender, String country_code,
			String pincode, String email, String mobile, String lang_known, int fees, boolean is_active,
			String service1_description, String service2_description, String service3_description) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.country_code = country_code;
		this.pincode = pincode;
		this.email = email;
		this.mobile = mobile;
		this.lang_known = lang_known;
		this.fees = fees;
		this.is_active = is_active;
		this.service1_description = service1_description;
		this.service2_description = service2_description;
		this.service3_description = service3_description;
	}

	public ServiceProviderEntity(long id, String fname, String lname, Gender gender, String country_code,
			String pincode, String email, String mobile, String lang_known, int fees, boolean is_active,
			ServicesEntity service1, String service1_description, ServicesEntity service2, String service2_description,
			ServicesEntity service3, String service3_description) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.country_code = country_code;
		this.pincode = pincode;
		this.email = email;
		this.mobile = mobile;
		this.lang_known = lang_known;
		this.fees = fees;
		this.is_active = is_active;
		this.service1 = service1;
		this.service1_description = service1_description;
		this.service2 = service2;
		this.service2_description = service2_description;
		this.service3 = service3;
		this.service3_description = service3_description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLang_known() {
		return lang_known;
	}

	public void setLang_known(String lang_known) {
		this.lang_known = lang_known;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public ServicesEntity getService1() {
		return service1;
	}

	public void setService1(ServicesEntity service1) {
		this.service1 = service1;
	}

	public String getService1_description() {
		return service1_description;
	}

	public void setService1_description(String service1_description) {
		this.service1_description = service1_description;
	}

	public ServicesEntity getService2() {
		return service2;
	}

	public void setService2(ServicesEntity service2) {
		this.service2 = service2;
	}

	public String getService2_description() {
		return service2_description;
	}

	public void setService2_description(String service2_description) {
		this.service2_description = service2_description;
	}

	public ServicesEntity getService3() {
		return service3;
	}

	public void setService3(ServicesEntity service3) {
		this.service3 = service3;
	}

	public String getService3_description() {
		return service3_description;
	}

	public void setService3_description(String service3_description) {
		this.service3_description = service3_description;
	}
	
	
}