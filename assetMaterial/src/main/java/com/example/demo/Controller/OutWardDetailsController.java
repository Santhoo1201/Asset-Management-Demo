package com.example.demo.Controller;

import java.io.Serializable;
import java.util.List;

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

import com.example.demo.Model.OutwardDetails;
import com.example.demo.Service.OutWardDetailsService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;



@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/outWardDetails")
public class OutWardDetailsController {
	
	@Autowired
	private OutWardDetailsService outWardDetailsService;

	public OutWardDetailsController(OutWardDetailsService outWardDetailsService) {
		super();
		this.outWardDetailsService = outWardDetailsService;
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
	
	@GetMapping("/assetId/{assetId}")
	public ResponseEntity<OutwardDetails> getOutwardDetaisByAssetId(@PathVariable("assetId")String assetId){
	
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.getOutwardDetaisByAssetId(assetId),HttpStatus.OK);
	}
	
	@PutMapping("/update/{outwardId}")
	public ResponseEntity<OutwardDetails> updateOutwardDetails(@PathVariable("outwardId") long outwardId,@RequestBody OutwardDetails outwardDetails){
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.updateOutwardDetails(outwardId,outwardDetails),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public  ResponseEntity<OutwardDetails> getOutwardDetaisById(@PathVariable("id") long id){
		
		return new ResponseEntity<OutwardDetails>(outWardDetailsService.getOutwardDetaisById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<OutwardDetails> getAllOutwardDetails(){
		
		return outWardDetailsService.getAllOutwardDetails();
	}
	
	@GetMapping("/modelId/{modelId}")
	public ResponseEntity<OutwardDetails> grtOutwardDetailsByModelId(@PathVariable("modelId") String modelId){
		
		return new ResponseEntity<OutwardDetails> (outWardDetailsService.grtOutwardDetailsByModelId(modelId),HttpStatus.OK);
	}

}
