package pkg1.iot1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IotController {
	@Autowired
	IotRepo iotr;
	
	@PostMapping("/pulse/add")
	public IotEntity addPulse(@RequestBody IotEntity iote) {
		return iotr.save(iote);
	}
	
	@GetMapping("/pulse/get/all")
	public List<IotEntity> getPulseDetails(){
		return iotr.findAll();
	}
	
	@GetMapping("/pulse/get/name")
	public IotEntity getByName(@RequestParam String name){
		return iotr.findByName(name);
	}
}
