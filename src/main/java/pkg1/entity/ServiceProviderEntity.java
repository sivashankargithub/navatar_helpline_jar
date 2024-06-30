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
	@Column(nullable = false, columnDefinition = "TINYINT(1) default 0")
	private boolean is_active=false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service1_id")
	private ServicesEntity service1;
	private String provider_description1;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service2_id")
	private ServicesEntity service2;
	private String provider_description2;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="service3_id")
	private ServicesEntity service3;
	private String provider_description3;
	
	@OneToMany(mappedBy = "serviceProvider")
	private List<ServiceTimingEntity> serviceTimingEntity;
	
	@OneToMany(mappedBy = "serviceProviderEntity")
	private List<AppointmentEntity> appointmentEntity;
	
	public ServiceProviderEntity() {
		super();
	}

	public ServiceProviderEntity(long id, String fname, String lname, Gender gender, String country_code,
			String pincode, String email, String mobile, String lang_known, boolean is_active, ServicesEntity service1,
			ServicesEntity service2, ServicesEntity service3) {
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
		this.is_active = is_active;
		this.service1 = service1;
		this.service2 = service2;
		this.service3 = service3;
	}
	
	public ServiceProviderEntity(long id, String fname, String lname, Gender gender, String country_code,
			String pincode, String email, String mobile, String lang_known, boolean is_active,
			String provider_description1, String provider_description2, String provider_description3) {
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
		this.is_active = is_active;
		this.provider_description1 = provider_description1;
		this.provider_description2 = provider_description2;
		this.provider_description3 = provider_description3;
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

	public ServicesEntity getService2() {
		return service2;
	}

	public void setService2(ServicesEntity service2) {
		this.service2 = service2;
	}

	public ServicesEntity getService3() {
		return service3;
	}

	public void setService3(ServicesEntity service3) {
		this.service3 = service3;
	}
	
	public String getProvider_description1() {
		return provider_description1;
	}

	public void setProvider_description1(String provider_description1) {
		this.provider_description1 = provider_description1;
	}

	public String getProvider_description2() {
		return provider_description2;
	}

	public void setProvider_description2(String provider_description2) {
		this.provider_description2 = provider_description2;
	}

	public String getProvider_description3() {
		return provider_description3;
	}

	public void setProvider_description3(String provider_description3) {
		this.provider_description3 = provider_description3;
	}

}