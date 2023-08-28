package com.project.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.Service.HrDetailsService;
import com.project.demo.model.HrDetails;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/hrDetails")

public class HrDetailsController {
	
	
	@Autowired
	private HrDetailsService hrDetailsService;
	
	
	public HrDetailsController(HrDetailsService hrDetailsService) {
		super();
		this.hrDetailsService = hrDetailsService;
	}




	@PostMapping("/addHrDetails")
	public ResponseEntity<HrDetails> saveHrDetails(@Valid @RequestBody HrDetails hrDetails){
		
		return new ResponseEntity<HrDetails> (hrDetailsService.saveHrDetails(hrDetails),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<HrDetails> loginHrDetails(@RequestBody HrDetails hrDetails){
		
		return new ResponseEntity<HrDetails> (hrDetailsService.loginHrDetails(hrDetails),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<HrDetails> getHrDetailsById(@PathVariable("id") long id,@RequestBody HrDetails hrDetails){
		
		
		return new ResponseEntity<HrDetails> (hrDetailsService.getHrDetailsById(id,hrDetails),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<HrDetails> editHrDetailsById(@PathVariable("id") long id,@RequestBody HrDetails hrDetails ){
		
		
		return new ResponseEntity<HrDetails> (hrDetailsService.editHrDetailsById(id,hrDetails),HttpStatus.OK);
	}

}
