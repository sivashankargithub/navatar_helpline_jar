package pkg1.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
		long cid = appointmentDto.getCustomer_id();
		long spid = appointmentDto.getService_provider_id();
		long sid = appointmentDto.getService_id();
		CustomersEntity getCust = cr.findById(cid)
				.orElseThrow(() -> new NullPointerException("Customer Not Exist With Id: "+cid));
		ServicesEntity getService = sr.findById(sid)
				.orElseThrow(() -> new NullPointerException("Service Not Exist With Id: "+sid));
		ServiceProviderEntity getSP=spr.findById(spid)
				.orElseThrow(() -> new NullPointerException("Service Not Exist With Id: "+spid));
		
		AppointmentEntity appointment = new AppointmentEntity();
		appointment=new AppointmentEntity(appointmentDto.getAppointment().getId(),
				appointmentDto.getAppointment().getAppointment_date_time(),
				appointmentDto.getAppointment().getIssue(),
				appointmentDto.getAppointment().getConnect(),
				appointmentDto.getAppointment().getWork_status(),
				appointmentDto.getAppointment().getPayment_id(),
				appointmentDto.getAppointment().getPayment_satus(),
				appointmentDto.getAppointment().getPayment_date(),
				LocalDateTime.now(),
				LocalDateTime.now());
		appointment.setCustomerEntity(getCust);
		appointment.setServicesEntity(getService);
		appointment.setServiceProviderEntity(getSP);
		AppointmentEntity saveAppointment = ar.save(appointment);
		return ResponseEntity.ok(saveAppointment);
	}
	
	@GetMapping("/appointment/get/all")
	public List<AppointmentEntity> getAllAppointments(){
		return ar.findAll();
	}
	@GetMapping("/appointment/get/{id}")
	public AppointmentEntity getAllAppointmentById(@PathVariable long id) {
		return ar.findById(id).orElseThrow(() -> new NullPointerException("Appointment Not Exist with Id: "+id));
	}
	
	@GetMapping("/appointment/get/by/customer/{cid}")
	public ResponseEntity<List<AppointmentEntity>> getAppointmentsByCustId(@PathVariable long cid) {
		CustomersEntity getCust = cr.findById(cid).orElseThrow(() -> new NullPointerException("Customer not exist with id "+cid));
		List<AppointmentEntity> appointByCust = ar.findAppointByCustId(getCust.getId());
		return ResponseEntity.ok(appointByCust);
	}
	
	@GetMapping("/appointment/get/by/serviceprovider/{spid}")
	public ResponseEntity<List<AppointmentEntity>> getAppointmentsBySPId(@PathVariable long spid) {
		ServiceProviderEntity getSP = spr.findById(spid).orElseThrow(() -> new NullPointerException("Service provider not exist with id "+spid));
		List<AppointmentEntity> appointByCust = ar.findAppointBySPId(getSP.getId());
		return ResponseEntity.ok(appointByCust);
	}
	
	@GetMapping("appointment/get/by/customer/{cid}/serviceprovider/{spid}")
	public ResponseEntity<List<AppointmentEntity>>getAppointByCidAndSpId(@PathVariable long cid, @PathVariable long spid){
		CustomersEntity getCust = cr.findById(cid).orElseThrow(() -> new NullPointerException("Customer not exist with id "+cid));
		ServiceProviderEntity getSP = spr.findById(spid).orElseThrow(() -> new NullPointerException("Service provider not exist with id "+spid));
		List<AppointmentEntity> getappoint = ar.findAppointByCustIdandSPid(getCust.getId(), getSP.getId());
		return ResponseEntity.ok(getappoint);
	}
	
	@PatchMapping("/appointment/update/by/appointment/{aid}")
	public ResponseEntity<AppointmentEntity> updateAppointmentByCustomer(@PathVariable long aid, @RequestBody AppointmentEntity ape) {
		AppointmentEntity saveAppointment = ar.findById(aid).orElseThrow(() -> new NullPointerException("Appointment not exist with id: "+aid));
		saveAppointment.setAppointment_date_time(ape.getAppointment_date_time());
		saveAppointment.setIssue(ape.getIssue());
		saveAppointment.setConnect(ape.getConnect());
		saveAppointment.setWork_status(ape.getWork_status());
		saveAppointment.setPayment_id(ape.getPayment_id());
		saveAppointment.setPayment_satus(ape.getPayment_satus());
		saveAppointment.setPayment_date(ape.getPayment_date());
		saveAppointment.setUpdatedAt(LocalDateTime.now());
		ar.save(saveAppointment);
		return ResponseEntity.ok(saveAppointment);
	}
	
	
}
