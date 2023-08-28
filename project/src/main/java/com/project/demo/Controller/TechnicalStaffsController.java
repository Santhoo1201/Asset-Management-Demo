package com.project.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.TechnicalStaffs;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/technicalstaffs")
//@CrossOrigin("*")
public class TechnicalStaffsController {
	
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	public TechnicalStaffsController(TechnicalStaffsService technicalStaffsService) {
		super();
		this.technicalStaffsService = technicalStaffsService;
	}





	@PostMapping("/addStaffs")
	public ResponseEntity<TechnicalStaffs> addStaffs(@Valid @RequestBody TechnicalStaffs technicalStaffs){
		
		
		return new ResponseEntity<TechnicalStaffs> (technicalStaffsService.addStaffs(technicalStaffs),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TechnicalStaffs> getTechnicalStaffsById(@PathVariable("id") long id){
		
		
		return new ResponseEntity<TechnicalStaffs> (technicalStaffsService.getTechnicalStaffsById(id),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TechnicalStaffs> loginTechnicalStaffs(@RequestBody TechnicalStaffs technicalStaffs){
	
		
		return new ResponseEntity<TechnicalStaffs> (technicalStaffsService.loginTechnicalStaffs(technicalStaffs),HttpStatus.OK);
	}

}
