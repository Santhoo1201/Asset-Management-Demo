package com.project.demo.Controller;

import java.util.List;

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

import com.project.demo.Service.CCTVService;
import com.project.demo.model.CCTV;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/cctv")
public class CCTVController {
	
	@Autowired
	private CCTVService cctvService;
	
	public CCTVController(CCTVService cctvService) {
		super();
		this.cctvService = cctvService;
	}



	@PostMapping("{id}")
	public ResponseEntity<CCTV> saveCCTV(@PathVariable("id") long id,@Valid @RequestBody CCTV cctv){
		
		
		return new ResponseEntity<CCTV> (cctvService.saveCCTV(id,cctv),HttpStatus.CREATED);
	}
	
//	@GetMapping("{id}")
//	public List<CCTV> getAllCCTV(@PathVariable("id") long id){
//		
//		return cctvService.getALLCCTV(id);
//	}
	
	@GetMapping("/fullList")
	public List<CCTV> getAll()
	{
		return cctvService.getAll();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<CCTV> getCCTVById(@PathVariable("id")long id,@RequestBody CCTV cctv){
		
		return new ResponseEntity<CCTV> (cctvService.getCCTVById(id,cctv),HttpStatus.OK);
	}
	

}
