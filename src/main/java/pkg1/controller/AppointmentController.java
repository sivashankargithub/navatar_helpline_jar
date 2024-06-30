package pkg1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.AppointmentDto;
import pkg1.entity.AppointmentEntity;
import pkg1.entity.CustomersEntity;
import pkg1.entity.ServiceProviderEntity;
import pkg1.entity.ServicesEntity;
import pkg1.repo.AppointmentRepo;
import pkg1.repo.CustomersRepo;
import pkg1.repo.ServiceProviderRepo;
import pkg1.repo.ServicesRepo;

@RestController
public class AppointmentController {
	@Autowired
	CustomersRepo cr;
	@Autowired
	ServicesRepo sr;
	@Autowired
	ServiceProviderRepo spr;
	@Autowired
	AppointmentRepo ar;
	@PostMapping("/appointment/add")
	public ResponseEntity<AppointmentEntity> addAppointment(@RequestBody AppointmentDto appointmentDto) {
		CustomersEntity custid = cr.findById(appointmentDto.getCustomer_id())
				.orElseThrow(() -> new RuntimeException("Customer id not found"));
		ServicesEntity serviceid = sr.findById(appointmentDto.getService_id())
				.orElseThrow(() -> new RuntimeException("Service id not found"));
		ServiceProviderEntity spid=spr.findById(appointmentDto.getService_provider_id())
				.orElseThrow(() -> new RuntimeException("Service provider id not found"));
		
		AppointmentEntity appointment = new AppointmentEntity();
		appointment=new AppointmentEntity(appointmentDto.getAppointment().getId(),
				appointmentDto.getAppointment().getAppointment_date_time(),
				appointmentDto.getAppointment().getIssue(),
				appointmentDto.getAppointment().getConnect(),
				appointmentDto.getAppointment().getWork_status(),
				appointmentDto.getAppointment().getPayment_id(),
				appointmentDto.getAppointment().getPayment_satus(),
				appointmentDto.getAppointment().getPayment_date(),
				appointmentDto.getAppointment().getCreatedAt(),
				appointmentDto.getAppointment().getUpdatedAt());
		appointment.setCustomerEntity(custid);
		appointment.setServicesEntity(serviceid);
		appointment.setServiceProviderEntity(spid);
		AppointmentEntity saveAppointment = ar.save(appointment);
		return ResponseEntity.ok(saveAppointment);
	}
	
	@GetMapping("/appointment/get/all")
	public List<AppointmentEntity> getAllAppointments(){
		return ar.findAll();
	}
	@GetMapping("/appointment/get/{id}")
	public AppointmentEntity getAllAppointmentById(@PathVariable long id) {
		return ar.findById(id).orElseThrow(() -> new RuntimeException("No appointments found"));
	}
}
