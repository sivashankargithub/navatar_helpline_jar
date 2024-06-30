package pkg1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.entity.CustomersEntity;
import pkg1.repo.CustomersRepo;

@RestController
public class CustomersController {
	@Autowired
	CustomersRepo cr;
	
	@PostMapping("/customer/add")
	public ResponseEntity<CustomersEntity> addCustomers(@RequestBody CustomersEntity ce) {
		return ResponseEntity.ok(cr.save(ce));
	}
	
	@GetMapping("/customer/get/all")
	public List<CustomersEntity> getAllCust(){
		return cr.findAll();
	}
	
}
