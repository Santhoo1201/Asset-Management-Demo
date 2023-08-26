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

import com.project.demo.Service.ServersService;
import com.project.demo.model.Servers;

import jakarta.validation.Valid;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/servers")
public class ServersController {
	
	
	@Autowired
	private ServersService serversService;
	
	
	public ServersController(ServersService serversService) {
		super();
		this.serversService = serversService;
	}





	@PostMapping("{id}")
	public ResponseEntity<Servers> saveServers(@Valid @RequestBody Servers servers,@PathVariable("id") long id){
		
		return new ResponseEntity<Servers> (serversService.saveServers(servers,id),HttpStatus.CREATED);
	}
	
	@GetMapping("/servers/{id}")
	public ResponseEntity<Servers> getServersById(@PathVariable("id") long id,@RequestBody Servers servers){
		
		
		return new ResponseEntity<Servers> (serversService.getServersById(id,servers),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public List<Servers> getAllServers(@PathVariable("id") long id){
		
		return serversService.getAllServers(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Servers> editServersById(@PathVariable("id") long id,@RequestBody Servers servers){
		
		return new ResponseEntity<Servers> (serversService.editServersById(id,servers),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Boolean> deleteServersById(@PathVariable("id") long id,@RequestBody Servers servers){
		
	serversService.deleteServersById(id,servers);
	Boolean flag=true;
	return new ResponseEntity<Boolean> (flag,HttpStatus.OK);
	
	}
	

}
