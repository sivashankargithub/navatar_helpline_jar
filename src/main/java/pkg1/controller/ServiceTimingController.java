package pkg1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.ServiceTimingDto;
import pkg1.entity.ServiceProviderEntity;
import pkg1.entity.ServiceTimingEntity;
import pkg1.repo.ServiceProviderRepo;
import pkg1.repo.ServiceTimingRepo;

@RestController
public class ServiceTimingController {
	@Autowired
	ServiceTimingRepo str;
	@Autowired
	ServiceProviderRepo spr;
	
	@PostMapping("/servicetiming/add")
	public ResponseEntity<ServiceTimingEntity> addServiceTimings(@RequestBody ServiceTimingDto stdto){
		long spid=stdto.getService_provider_id();
		ServiceProviderEntity sp=spr.findById(spid)
				.orElseThrow(() -> new RuntimeException("Service Provider not exist with id "+stdto.getService_provider_id()));
		
		ServiceTimingEntity saveSerTime=new ServiceTimingEntity();
		saveSerTime.setService_day(stdto.getServiceTimings().getService_day());
		saveSerTime.setTimings(stdto.getServiceTimings().getTimings());
		saveSerTime.setServiceProvider(sp);
		str.save(saveSerTime);
		return ResponseEntity.ok(saveSerTime);
	}
	
	@GetMapping("/servicetiming/get/all")
	public List<ServiceTimingEntity> getAllTimings(){
		return str.findAll();
	}
	
	@GetMapping("/servicetiming/get/{spid}")
	public ResponseEntity<List<ServiceTimingEntity>> getServiceTimingsByServiceProviderId(@PathVariable long spid) {
		try {
			ServiceProviderEntity getSP=spr.findById(spid).orElseThrow(() -> new IllegalArgumentException("Service provider not exist with id "+spid));
			List<ServiceTimingEntity> getServiceTiming = str.findAllSTBySPId(getSP.getId());
			return ResponseEntity.ok(getServiceTiming);
		}
		catch (IllegalArgumentException e) {
			System.err.println("Service Provider not exist with id "+spid+" or Service Timing not exist for id "+spid);
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/servicetiming/get/{spid}/{day}")
	public ServiceTimingEntity getSTBySPIdandDay(@PathVariable long spid, @PathVariable String day) {
		ServiceTimingEntity getServiceTiming = str.findSPTimingsBySPId(spid,day).orElseThrow(() -> new RuntimeException("Service provider not exist with id "+spid));
		return getServiceTiming;
	}
	
	@PatchMapping("/servicetiming/update/by/serviceprovider/id/and/day")
	public ResponseEntity<ServiceTimingEntity> updateServiceTimings(@RequestBody ServiceTimingDto stdto){
		long spid = stdto.getService_provider_id();
		String day = stdto.getServiceTimings().getService_day().name();
		ServiceTimingEntity saveSerTime = str.findSPTimingsBySPId(spid,day).orElseThrow(() -> new RuntimeException("Service Provider not exist with id "+spid));
		saveSerTime.setTimings(stdto.getServiceTimings().getTimings());
		str.save(saveSerTime);
		return ResponseEntity.ok(saveSerTime);
	}
	
//	@GetMapping("/servicetiming/get/nextoneweek")
//	public NextWeekTimingDto getNextWeek(@RequestParam int id) {
//		Optional<ServiceTimingEntity>sertime1=str.findServiceProviderTimingsByServiceProviderId(id);
//		List<String>date1=new ArrayList<>();
//		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
//		LocalDate mydate1;
//		LocalDate mydate2;
//		String mydate3;
//		for(int i=0;i<14;i++) {
//			mydate1=LocalDate.now();
//			mydate2=mydate1.plusDays(i);
//			mydate3=mydate2.format(dtf1);
//			date1.add(mydate3);
//		}	
//	}
}