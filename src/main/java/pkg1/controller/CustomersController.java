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
	
	@GetMapping("/customer/get/{id}")
	public ResponseEntity<CustomersEntity> getCustById(@PathVariable long id) {
		CustomersEntity ce=cr.findById(id).orElseThrow(() -> new RuntimeException("customer not exist with id "+id));
		return ResponseEntity.ok(ce);
	}	
	
	@PatchMapping("/customer/update/{id}")
	public ResponseEntity<CustomersEntity> updateCustomer(@PathVariable long id, @RequestBody CustomersEntity ce){
		CustomersEntity updateCust = cr.findById(id).orElseThrow(() -> new RuntimeException("Customer not exist with id "+id));
		updateCust.setFname(ce.getFname());
		updateCust.setLname(ce.getLname());
		updateCust.setGender(ce.getGender());
		updateCust.setCountry_code(ce.getCountry_code());
		updateCust.setCountry_city(ce.getCountry_city());
		updateCust.setZipcode(ce.getZipcode());
		updateCust.setEmail(ce.getEmail());
		updateCust.setMobile(ce.getMobile());
		updateCust.setLang_known(ce.getLang_known());
		cr.save(updateCust);
		return ResponseEntity.ok(updateCust);
	}
	
}
