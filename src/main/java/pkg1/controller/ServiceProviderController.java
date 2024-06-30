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
import org.springframework.web.bind.annotation.GetMapping;

	

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
      		   spdto.getServiceProvider().isIs_active(),
      		   spdto.getServiceProvider().getProvider_description1(),
      		   spdto.getServiceProvider().getProvider_description2(),
      		   spdto.getServiceProvider().getProvider_description3());
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
    
    

}
