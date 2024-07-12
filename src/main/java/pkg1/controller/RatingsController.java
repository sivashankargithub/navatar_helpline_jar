package pkg1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pkg1.dto.RatingsDto;
import pkg1.entity.AppointmentEntity;
import pkg1.entity.RatingsEntity;
import pkg1.repo.AppointmentRepo;
import pkg1.repo.RatingsRepo;

@RestController
public class RatingsController {
	
	@Autowired
	AppointmentRepo apr;
	
	@Autowired
	RatingsRepo rr;
	
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
	
}
