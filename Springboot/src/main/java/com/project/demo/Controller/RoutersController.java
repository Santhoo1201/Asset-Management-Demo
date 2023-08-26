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

import com.project.demo.Service.RoutersService;
import com.project.demo.model.Routers;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/routers")
public class RoutersController {
	
	
	@Autowired
	private RoutersService routersService;
	
	
	public RoutersController(RoutersService routersService) {
		super();
		this.routersService = routersService;
	}




	@PostMapping("{id}")
	public ResponseEntity<Routers> saveRouters(@Valid @RequestBody Routers routers,@PathVariable("id") long id ){
		
		
		return new ResponseEntity<Routers> (routersService.saveRouters(routers,id),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public List<Routers> getAllRouters(@PathVariable("id") long id){
		
		
		return  routersService.getAllRouters(id);
	}
	
	
	@GetMapping("/routers/{id}")
	public ResponseEntity<Routers> getRoutersById(@PathVariable("id") long id,@RequestBody Routers routers){
		
		return new ResponseEntity<Routers> (routersService.getRoutersById(id,routers),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Routers> editRoutersById(@PathVariable("id") long id,@RequestBody Routers routers){
		
		return new ResponseEntity<Routers> (routersService.editRoutersById(id,routers),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRoutersById(@PathVariable("id") long id,@RequestBody Routers routers){
		
		routersService.deleteRoutersById(id,routers);
		String s="Successfully Deleted the ID";
		return new ResponseEntity<String>(s,HttpStatus.OK);
		
	}

}
