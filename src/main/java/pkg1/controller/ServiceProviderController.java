package pkg1.controller;

import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.ServiceProviderDto;
import pkg1.entity.ServiceProviderEntity;
import pkg1.entity.ServicesEntity;
import pkg1.repo.ServiceProviderRepo;
import pkg1.repo.ServicesRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ServiceProviderController {
    @Autowired
    ServiceProviderRepo spr;

    @Autowired
    ServicesRepo sr; 

    @PostMapping("/serviceprovider/add")
    public ResponseEntity<ServiceProviderEntity> addServiceProvider(@RequestBody ServiceProviderDto spdto) {
        Optional<ServicesEntity> se1 = sr.findById(spdto.getService1_id());
        Optional<ServicesEntity> se2 = sr.findById(spdto.getService2_id());
        Optional<ServicesEntity> se3 = sr.findById(spdto.getService3_id());
        
        ServiceProviderEntity spe1=new ServiceProviderEntity();        
        spe1 = new ServiceProviderEntity(spdto.getServiceProvider().getId(),
      		   spdto.getServiceProvider().getFname(), 
      		   spdto.getServiceProvider().getLname(),
      		   spdto.getServiceProvider().getGender(),
      		   spdto.getServiceProvider().getCountry_code(),
      		   spdto.getServiceProvider().getPincode(),
      		   spdto.getServiceProvider().getEmail(),
      		   spdto.getServiceProvider().getMobile(),
      		   spdto.getServiceProvider().getLang_known(),
      		   spdto.getServiceProvider().getFees(),
      		   spdto.getServiceProvider().isIs_active(),
      		   spdto.getServiceProvider().getService1_description(),
      		   spdto.getServiceProvider().getService2_description(),
      		   spdto.getServiceProvider().getService3_description());
        if(se1.isPresent()) {
     	   spe1.setService1(se1.get());
        }
        if(se2.isPresent()){
     	   spe1.setService2(se2.get());
        }
        if(se3.isPresent()){
     	   spe1.setService3(se3.get());
        }
        if(se1.isEmpty() && se2.isEmpty() && se3.isEmpty()) {
     	   return ResponseEntity.badRequest().build();
        }
        
       ServiceProviderEntity speSaved=spr.save(spe1);
       return ResponseEntity.ok(speSaved);
    }

    @GetMapping("/serviceprovider/get/all")
    public List<ServiceProviderEntity> getAllServiceProviders() {
        return spr.findAll();
    }
    
    @GetMapping("/serviceprovider/get/serviceid")
    public List<ServiceProviderEntity>getServiceproviderByServiceId(@RequestParam long id){
    	return spr.findServiceProviderByServiceId(id);
    }
    
    @PatchMapping("/serviceprovider/update/{id}")
    public ResponseEntity<ServiceProviderEntity> updateServiceProvider(@PathVariable long id, @RequestBody ServiceProviderDto spdto) {
    	ServiceProviderEntity updateSP = spr.findById(id).orElseThrow(() -> new RuntimeException("Service provider not exist with id "+id));
    	
    	Optional<ServicesEntity> s1 = sr.findById(spdto.getService1_id());
        Optional<ServicesEntity> s2 = sr.findById(spdto.getService2_id());
        Optional<ServicesEntity> s3 = sr.findById(spdto.getService3_id());
    	
    	updateSP.setFname(spdto.getServiceProvider().getFname());
    	updateSP.setLname(spdto.getServiceProvider().getLname());
    	updateSP.setGender(spdto.getServiceProvider().getGender());
    	updateSP.setCountry_code(spdto.getServiceProvider().getCountry_code());
    	updateSP.setPincode(spdto.getServiceProvider().getPincode());
    	updateSP.setEmail(spdto.getServiceProvider().getEmail());
    	updateSP.setMobile(spdto.getServiceProvider().getMobile());
    	updateSP.setLang_known(spdto.getServiceProvider().getLang_known());
    	updateSP.setFees(spdto.getServiceProvider().getFees());
    	updateSP.setIs_active(spdto.getServiceProvider().isIs_active());
    	updateSP.setService1_description(spdto.getServiceProvider().getService1_description());
    	updateSP.setService2_description(spdto.getServiceProvider().getService2_description());
    	updateSP.setService3_description(spdto.getServiceProvider().getService3_description());
    	
    	if(s1.isPresent()) {
    		updateSP.setService1(s1.get());
         }
         if(s2.isPresent()){
        	 updateSP.setService2(s2.get());
         }
         if(s3.isPresent()){
        	 updateSP.setService3(s3.get());
         }
         if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
      	   return ResponseEntity.badRequest().build();
         }
    	spr.save(updateSP);
    	return ResponseEntity.ok(updateSP);
    }
    
}
