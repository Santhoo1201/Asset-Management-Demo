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

import com.example.demo.model.MaterialDetails;
import com.example.demo.service.MaterilaDetialsService;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/materialDetails")
public class MaterialDetailsController  {
	
	@Autowired
	private MaterilaDetialsService materilaDetialsService;

	public MaterialDetailsController(MaterilaDetialsService materilaDetialsService) {
		super();
		this.materilaDetialsService = materilaDetialsService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<MaterialDetails> saveMaterialDetails(@Valid @RequestBody MaterialDetails materialDetails){
		
		return new ResponseEntity<MaterialDetails>(materilaDetialsService.saveMaterialDetails(materialDetails),HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAll")
	public ResponseEntity<List<MaterialDetails>> saveAllMaterialDetails(@Valid @RequestBody List<MaterialDetails> materialDetails){
		
		return new ResponseEntity<List<MaterialDetails>>(materilaDetialsService.saveAllMaterialDetails(materialDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllMaterialDetails")
	public ResponseEntity<List<String>> getAllMaterialoDetails(){
		
		List<String> settedValue=new ArrayList<String>();
		List<MaterialDetails> getValue=materilaDetialsService.getAllMaterialoDetails();
		for(MaterialDetails setThatVAlue:getValue) {
			settedValue.add(setThatVAlue.getMaterialAssetId()+"--"+setThatVAlue.getMaterialName()+"--"+setThatVAlue.getMaterialModelId());
		}
		return new ResponseEntity<List<String>>(settedValue,HttpStatus.OK);
	}
	

}
