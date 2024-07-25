package pkg1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.RatingsDto;
import pkg1.entity.AppointmentEntity;
import pkg1.entity.CustomersEntity;
import pkg1.entity.RatingsEntity;
import pkg1.entity.ServiceProviderEntity;
import pkg1.repo.AppointmentRepo;
import pkg1.repo.CustomersRepo;
import pkg1.repo.RatingsRepo;
import pkg1.repo.ServiceProviderRepo;

@RestController
public class RatingsController {
	
	@Autowired
	AppointmentRepo apr;
	
	@Autowired
	RatingsRepo rr;
	
	@Autowired
	CustomersRepo cr;
	
	@Autowired
	ServiceProviderRepo spr;
	
	@PostMapping("/ratings/add")
	public ResponseEntity<RatingsEntity> addRatings(@RequestBody RatingsDto ratingsDto) {
		AppointmentEntity apoint_id=apr.findById(ratingsDto.getAppointment_id()).orElseThrow(() -> new RuntimeException("Appointment id not found"));
		RatingsEntity re = new RatingsEntity();
		re=new RatingsEntity(ratingsDto.getRatings().getId(),
				ratingsDto.getRatings().getCustomer_rating(),
				ratingsDto.getRatings().getCustomer_description(),
				ratingsDto.getRatings().getService_provider_rating(),
				ratingsDto.getRatings().getService_provider_description());
		re.setAppointment(apoint_id);
		RatingsEntity saveRatings = rr.save(re);
		return ResponseEntity.ok(saveRatings);
	}
	
	@GetMapping("/ratings/get/all")
	public ResponseEntity<List<RatingsEntity>> getAllRatings(){
		try {
			List<RatingsEntity> getAllrating = rr.findAll();
			return ResponseEntity.ok(getAllrating);
		}
		catch (NullPointerException e) {
			System.err.println(e);
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/ratings/get/{id}")
	public ResponseEntity<RatingsEntity> getRatingsById(@PathVariable long id){
		RatingsEntity getRating=rr.findById(id).orElseThrow(() -> new NullPointerException("ratings not exist with id "+id));
		return ResponseEntity.ok(getRating);
	}
	@GetMapping("/ratings/get/appointment/{aid}")
	public ResponseEntity<RatingsEntity> getRatingsByAppointmentId(@PathVariable long aid){
		AppointmentEntity getAppoint = apr.findById(aid).orElseThrow(() -> new NullPointerException("No appointment exist with id: "+aid));
		RatingsEntity findRating = rr.findRatingByApId(getAppoint.getId());
		return ResponseEntity.ok(findRating);
	}
	
	
	@GetMapping("/ratings/get/serviceprovider/{spid}")
	public ResponseEntity<List<RatingsEntity>> getRatingsBySPId(@PathVariable long spid){
		List<RatingsEntity>getRating = new ArrayList<>();
		ServiceProviderEntity getSP = spr.findById(spid).orElseThrow(() -> new NullPointerException("Service provider not exist with id "+spid));
		List<AppointmentEntity> getApppoint = apr.findAppointBySPId(getSP.getId());
		for(int i=0; i< getApppoint.size();i++) {
			getRating.add(rr.findRatingByApId(getApppoint.get(i).getId()));
		}
		return ResponseEntity.ok(getRating);
	}
	
	@GetMapping("/ratings/get/customer/{cid}")
	public ResponseEntity<List<RatingsEntity>> getRatingsByCId(@PathVariable long cid){
		List<RatingsEntity>getRating = new ArrayList<>();
		CustomersEntity getcust = cr.findById(cid).orElseThrow(() -> new NullPointerException("Customer not exist with id "+cid));
		List<AppointmentEntity> getApppoint = apr.findAppointByCustId(getcust.getId());
		for(int i=0; i< getApppoint.size();i++) {
			getRating.add(rr.findRatingByApId(getApppoint.get(i).getId()));
		}
		return ResponseEntity.ok(getRating);
	}
	
	@GetMapping("/ratings/get/customer/{cid}/serviceprovider/{spid}")
	public ResponseEntity<List<RatingsEntity>> getRatingsByCIdandSPid(@PathVariable long cid, @PathVariable long spid){
		List<RatingsEntity>getRating = new ArrayList<>();
		CustomersEntity getcust = cr.findById(cid).orElseThrow(() -> new NullPointerException("Customer not exist with id "+cid));
		ServiceProviderEntity getSP = spr.findById(spid).orElseThrow(() -> new NullPointerException("Service provider not exist with id "+spid));
		List<AppointmentEntity> getApppoint = apr.findAppointByCustIdandSPid(getcust.getId(),getSP.getId());
		for(int i=0; i< getApppoint.size();i++) {
			getRating.add(rr.findRatingByApId(getApppoint.get(i).getId()));
		}
		return ResponseEntity.ok(getRating);
	}
	
	@PatchMapping("/ratings/update/appointment/{aid}")
	public ResponseEntity<RatingsEntity> updateRatingsByAppointmentId(@PathVariable long aid, @RequestBody RatingsEntity re){
		AppointmentEntity getAppoint = apr.findById(aid).orElseThrow(() -> new NullPointerException("No appointment exist with id: "+aid));
		RatingsEntity updateRating = rr.findRatingByApId(getAppoint.getId());
		updateRating.setCustomer_rating(re.getCustomer_rating());
		updateRating.setCustomer_description(re.getCustomer_description());
		updateRating.setService_provider_rating(re.getService_provider_rating());
		updateRating.setService_provider_description(re.getService_provider_description());
		rr.save(updateRating);
		return ResponseEntity.ok(updateRating);
	}
}
