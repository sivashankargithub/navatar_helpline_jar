package pkg1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.additioal.FindServices;
import pkg1.entity.ServiceProviderEntity;
import pkg1.entity.ServicesEntity;
import pkg1.repo.ServiceProviderRepo;
import pkg1.repo.ServicesRepo;

@RestController
public class ServicesController {
	@Autowired
	ServicesRepo sr1;
	
	@Autowired
	ServiceProviderRepo spr; 
	
	@PostMapping("/services/add")
	public ResponseEntity<ServicesEntity> addService(@RequestBody ServicesEntity se) {
		ServicesEntity savese=sr1.save(se);
		return ResponseEntity.ok(savese);
	}
	
	@GetMapping("/services/get/all")
	public List<ServicesEntity> getAllServices(){
		return sr1.findAll();
	}
	
	@GetMapping("/services/get/{id}")
	public ResponseEntity<ServicesEntity> getServiceById(@PathVariable long id) {
		ServicesEntity se=sr1.findById(id).orElseThrow(() -> new RuntimeException("Service not exist with id "+id));
		return ResponseEntity.ok(se);
	}
	
	@GetMapping("/services/get/serviceprovider/{id}")
    public ResponseEntity<FindServices> getServicesBySPId(@PathVariable long id) {
		try {
			Optional<ServiceProviderEntity> findSP=spr.findById(id);
			ServicesEntity service1 = findSP.get().getService1();
			ServicesEntity service2 = findSP.get().getService2();
			ServicesEntity service3 = findSP.get().getService3();
			FindServices displayServices = new FindServices();
			displayServices.setService1(service1);
			displayServices.setService2(service2);
			displayServices.setService3(service3);
			return ResponseEntity.ok(displayServices);
		}
		catch (NullPointerException e) {
			System.err.println("Service Provider not exist with id "+id);
			return ResponseEntity.badRequest().build();
		}
		
    	
    }
	
	@PatchMapping("/services/update/{id}")
	public ResponseEntity<ServicesEntity> updateServiceById(@PathVariable long id, @RequestBody ServicesEntity se1) {
		ServicesEntity updateService=sr1.findById(id).orElseThrow(() -> new RuntimeException("Service not exist with id "+id));
		updateService.setService_name(se1.getService_name());
		return ResponseEntity.ok(updateService);
	}	
}
