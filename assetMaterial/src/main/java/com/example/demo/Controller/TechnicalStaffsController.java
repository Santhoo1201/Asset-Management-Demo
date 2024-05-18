package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TechnicalStaffs;
import com.example.demo.Service.TechnicalStaffsService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/technicaStaffs")

public class TechnicalStaffsController {
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;

	public TechnicalStaffsController(TechnicalStaffsService technicalStaffsService) {
		super();
		this.technicalStaffsService = technicalStaffsService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<TechnicalStaffs> saveTechnicalStaff(@RequestBody TechnicalStaffs technicalStaffs){
		
		return new ResponseEntity<TechnicalStaffs>(technicalStaffsService.saveTechnicalStaff(technicalStaffs),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TechnicalStaffs> loginTechnicalStaff(@RequestBody TechnicalStaffs technicalStaffs){
		
		return new ResponseEntity<TechnicalStaffs> (technicalStaffsService.loginTechnicalStaff(technicalStaffs),HttpStatus.OK);
	}

}
