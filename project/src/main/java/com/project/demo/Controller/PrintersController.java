package com.project.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.Service.PrintersService;
import com.project.demo.model.Printers;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/printers")
public class PrintersController {
	
	
	@Autowired
	private PrintersService printersService;
	
	
	
	public PrintersController(PrintersService printersService) {
		super();
		this.printersService = printersService;
	}



	@PostMapping("{id}")
	public ResponseEntity<Printers> savePrinters(@Valid @RequestBody Printers printers,@PathVariable("id") long id){
		
		
		return new ResponseEntity<Printers> (printersService.savePrinters(printers,id),HttpStatus.CREATED);
	}
	
	@GetMapping("/printers/{id}")
	public ResponseEntity<Printers> getPrintersById(@PathVariable("id") long id,@RequestBody Printers printers){
		
		
		return new ResponseEntity<Printers>(printersService.getPrintersById(id,printers),HttpStatus.OK);
	}
	
	
	@GetMapping("{id}")
	public List<Printers> getAllPrinters(@PathVariable("id") long id){
		
		
		return printersService.getAllPrinters(id);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Printers> editPrinters(@PathVariable("id") long id,@RequestBody Printers printers){
		
		
		return new ResponseEntity<Printers> (printersService.editPrinters(id,printers),HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deletePrinters(@PathVariable("id") long id,@RequestBody Printers printers){
		
		printersService.deletePrinters(id,printers);
		Boolean flag=true;
		 return new ResponseEntity<Boolean> (flag,HttpStatus.OK);
	}

}
