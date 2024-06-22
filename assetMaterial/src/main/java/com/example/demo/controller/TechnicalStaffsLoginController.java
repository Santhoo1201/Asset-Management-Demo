package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TechnicalStaffs;
import com.example.demo.responseAndDto.TechnicalStaffsLoginResp;
import com.example.demo.service.TechnicalStaffsService;
import com.example.demo.serviceImpl.JwtLoadItems;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class TechnicalStaffsLoginController {
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	@Autowired
	private JwtLoadItems jwtLoadItems;
	
	
	@PostMapping("/signup")
	public ResponseEntity<TechnicalStaffs> signUp(@RequestBody TechnicalStaffs technicalStaffs){
		
		return new ResponseEntity<TechnicalStaffs>(technicalStaffsService.signUp(technicalStaffs),HttpStatus.CREATED);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<TechnicalStaffsLoginResp> signIn(@RequestBody TechnicalStaffs technicalStaffs){
		
		TechnicalStaffs getStaffs = technicalStaffsService.signIn(technicalStaffs);
		String token = jwtLoadItems.generteToken(getStaffs);
		TechnicalStaffsLoginResp loginResponse= new TechnicalStaffsLoginResp(token,jwtLoadItems.expiration());
		
		return new ResponseEntity<TechnicalStaffsLoginResp>(loginResponse,HttpStatus.OK);
	}
	

}
