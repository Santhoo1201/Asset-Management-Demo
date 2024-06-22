package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TechnicalStaffs;
import com.example.demo.service.TechnicalStaffsService;
import com.example.demo.serviceImpl.JwtLoadItems;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/technicaStaffs")

public class TechnicalStaffsController {
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	@Autowired
	private JwtLoadItems jwtLoadItems;

	public TechnicalStaffsController(TechnicalStaffsService technicalStaffsService) {
		super();
		this.technicalStaffsService = technicalStaffsService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<TechnicalStaffs> saveTechnicalStaff(@Valid @RequestBody TechnicalStaffs technicalStaffs){
		
		return new ResponseEntity<TechnicalStaffs>(technicalStaffsService.saveTechnicalStaff(technicalStaffs),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TechnicalStaffs> loginTechnicalStaff(@RequestBody TechnicalStaffs technicalStaffs){
		
		TechnicalStaffs getLogin=technicalStaffsService.loginTechnicalStaff(technicalStaffs);
		if(getLogin==null) {
			
			return new ResponseEntity<TechnicalStaffs>(getLogin,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<TechnicalStaffs> (technicalStaffsService.loginTechnicalStaff(technicalStaffs),HttpStatus.OK);
	}
	
	@GetMapping("/getAllTechnicalStaffs")
	public List<String> getAllTechnicalstaffs(){
		
		List<TechnicalStaffs> getToSetInString=	technicalStaffsService.getAllTechnicalStaffs();
		List<String> letSet = new ArrayList<String>();
		for(TechnicalStaffs letGet :getToSetInString ) {
			letSet.add(letGet.getSfmId()+"--"+letGet.getSfmName()+"--"+letGet.getSfmRole());	
		}
		return letSet;
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logoutTechincalStaffs(HttpServletRequest request){
		
		String getAuthHeader = request.getHeader("Authorization");
		String token = getAuthHeader.substring(7);
		if(token != null) {
			jwtLoadItems.logOutToken(token);
			System.out.println("Successfully logout ...! ");
		}
		return new ResponseEntity<String>("Successfully Logout..!",HttpStatus.OK);
	}

}
