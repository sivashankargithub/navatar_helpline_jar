package pkg1.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<ServiceTimingEntity> addServiceTimings(@RequestBody ServiceTimingDto stdto) throws BadRequestException{
		ServiceTimingEntity ste=new ServiceTimingEntity();
		ste=new ServiceTimingEntity(stdto.getServiceTimings().getId(),
				stdto.getServiceTimings().getService_day(),
				stdto.getServiceTimings().getTimings());
		ServiceProviderEntity spid=spr.findById(stdto.getService_provider_id())
				.orElseThrow(() -> new BadRequestException("service Provider id is not found"));
		ste.setServiceProvider(spid);
		ServiceTimingEntity savedste=str.save(ste);
		return ResponseEntity.ok(savedste);
	}
	
	@GetMapping("/servicetiming/get/all")
	public List<ServiceTimingEntity> getAllTimings(){
		return str.findAll();
	}

}
