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

import com.example.demo.model.InwardDetails;
import com.example.demo.responseAndDto.DulpicateMaterialDetails;
import com.example.demo.service.InwardDetailsService;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/inwardDetails")
public class InwardController {
	
	
	@Autowired
	private InwardDetailsService inwardDetailsService;
	
	
	@PostMapping("/addInwardDetails")
	public ResponseEntity<List<InwardDetails>> addAllInwardDetails(@RequestBody List<InwardDetails> inwardDetails){
		
		return new ResponseEntity<List<InwardDetails>>(inwardDetailsService.addAllInwardDetails(inwardDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllInwardDetails")
	public ResponseEntity<List<DulpicateMaterialDetails>> getAllInwardDetails(){
		
		List<InwardDetails> getTheInwardDetails = inwardDetailsService.getAllInwardDetails();
		List<DulpicateMaterialDetails> settedInwardDetails = new ArrayList<>();
		for(InwardDetails toSetValue : getTheInwardDetails) {
			
			String[] getSplitMaterials = toSetValue.getMaterial().split("--");
			String[] getSplitReceivedSfm = toSetValue.getReceivedSfmBy().split("--");
			
			String getAssetNo = getSplitMaterials[0];
			String getMaterialName = getSplitMaterials[1];
			String getModelName = getSplitMaterials[2];
			String getReceivedSfmName = getSplitReceivedSfm[1];
			
			String getVisitorName = "";
			String getVisitorNo = "";
			
			if(toSetValue.getVisitors() != null && !toSetValue.getVisitors().isEmpty()) {
				
				String[] getSplitVisitors = toSetValue.getVisitors().split("--");
				
				 getVisitorName = getSplitVisitors[0];
				 getVisitorNo = getSplitVisitors[1];
			}else {
				
				String[] getSplitVisitorsSfm = toSetValue.getVisitorsSfm().split("--");
				
				getVisitorName = getSplitVisitorsSfm[1];
			}
			
			settedInwardDetails.add(new DulpicateMaterialDetails(getAssetNo,getMaterialName,getModelName,getVisitorName,toSetValue.getReceiverDate(),getReceivedSfmName));
			
		}
		return new ResponseEntity<List<DulpicateMaterialDetails>>(settedInwardDetails,HttpStatus.OK);
	}
	

}
