package com.example.demo.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OutwardDetails;
import com.example.demo.responseAndDto.DulpicateMaterialDetails;
import com.example.demo.service.OutWardDetailsService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;



@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/outWardDetails")
public class OutWardDetailsController {
	
	@Autowired
	private OutWardDetailsService outWardDetailsService;
	
	@Autowired
	private DulpicateMaterialDetails dulpicateMaterialDetails;
	

	public OutWardDetailsController(OutWardDetailsService outWardDetailsService,
			DulpicateMaterialDetails dulpicateMaterialDetails) {
		super();
		this.outWardDetailsService = outWardDetailsService;
		this.dulpicateMaterialDetails = dulpicateMaterialDetails;
	}

	@PostMapping("/save")
	public ResponseEntity<OutwardDetails> savedetails(@RequestBody OutwardDetails outwardDetails){
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.saveDetails(outwardDetails),HttpStatus.CREATED);
	}
	
	@PostMapping("/saveAllDetails")
	
	public ResponseEntity<List<OutwardDetails>> saveAllDetails(@RequestBody List<OutwardDetails> outwardDetails){
		
//		ObjectMapper obj=new ObjectMapper();
//		ObjectReader outward=obj.reader(outwardDetails);
		
//		List<OutwardDetails> source=outwardDetails.getData();
		return new ResponseEntity<List<OutwardDetails>> (outWardDetailsService.saveAllDetails((List<OutwardDetails>) outwardDetails),HttpStatus.CREATED);
	}
	
//	@GetMapping("/assetId/{assetId}")
//	public ResponseEntity<OutwardDetails> getOutwardDetaisByAssetId(@PathVariable("assetId")String assetId){
//	
//		
//		return new ResponseEntity<OutwardDetails>(outWardDetailsService.getOutwardDetaisByAssetId(assetId),HttpStatus.OK);
//	}
	
	@PutMapping("/update/{outwardId}")
	public ResponseEntity<OutwardDetails> updateOutwardDetails(@PathVariable("outwardId") long outwardId,@RequestBody OutwardDetails outwardDetails){
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.updateOutwardDetails(outwardId,outwardDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public  ResponseEntity<OutwardDetails> getOutwardDetaisById(@PathVariable("id") long id){
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.getOutwardDetaisById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DulpicateMaterialDetails>> getAllOutwardDetails(){
		
		List<OutwardDetails> getValue= outWardDetailsService.getAllOutwardDetails();
		Map<String,String> settedValue=new HashMap<String,String>();
		List<DulpicateMaterialDetails> sendtype= new ArrayList<>();
		for(OutwardDetails setValue:getValue) {
			String[] getIdNamerole=setValue.getReceiverSfm().split("--");
			String[] getAssetMaterialNameModel=setValue.getMaterial().split("--");
			String[] getAssignedName=setValue.getAssignedSfm().split("--");
			if(getIdNamerole.length==3 && getAssetMaterialNameModel.length==3 && getAssignedName.length==3 ) {
				String assetNo=getAssetMaterialNameModel[0];
				String materialName=getAssetMaterialNameModel[1];
				String modelName=getAssetMaterialNameModel[2];
				String personName=getIdNamerole[1];
				String outwardDate=setValue.getSendDate();
				String assignedBy=getAssignedName[1];
				sendtype.add(new DulpicateMaterialDetails(assetNo,materialName,modelName,personName,outwardDate,assignedBy));
			}
//			settedValue.put(dulpicateMaterialDetails.getPersonName(),getIdNamerole[1]);
//			settedValue.put(dulpicateMaterialDetails.getAssetNo(),getAssetMaterialNameModel[0]);
//			settedValue.put(dulpicateMaterialDetails.getMaterialName(),getAssetMaterialNameModel[1]);
//			settedValue.put(dulpicateMaterialDetails.getModelName(),getAssetMaterialNameModel[2]);
//			settedValue.put(dulpicateMaterialDetails.getOutwardDate(), setValue.getSendDate());
//			settedValue.put(dulpicateMaterialDetails.getAssignedBy(),getAssignedName[1]);
//			
		}
		
		
		return new ResponseEntity<List<DulpicateMaterialDetails>> (sendtype,HttpStatus.OK);
		
	}
	
//	@GetMapping("/modelId/{modelId}")
//	public ResponseEntity<OutwardDetails> grtOutwardDetailsByModelId(@PathVariable("modelId") String modelId){
//		
//		return new ResponseEntity<OutwardDetails> (outWardDetailsService.grtOutwardDetailsByModelId(modelId),HttpStatus.OK);
//	}

}
