package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MaterialDetails;
import com.example.demo.repository.MaterialDetailsRepository;
import com.example.demo.service.MaterilaDetialsService;

import jakarta.validation.Valid;


@Service
public class MaterialDetailsServiceImpl implements MaterilaDetialsService {
	
	@Autowired
	private MaterialDetailsRepository materialDetailsRepository;

	public MaterialDetailsServiceImpl(MaterialDetailsRepository materialDetailsRepository) {
		super();
		this.materialDetailsRepository = materialDetailsRepository;
	}
	
	@Override
	public MaterialDetails saveMaterialDetails(@Valid MaterialDetails materialDetails) {
		
		return materialDetailsRepository.save(materialDetails);
	}
	
	@Override
	public List<MaterialDetails> saveAllMaterialDetails(@Valid List<MaterialDetails> materialDetails){
		
		return (List<MaterialDetails>) materialDetailsRepository.saveAll(materialDetails);
	}
	
	@Override
	public List<MaterialDetails> getAllMaterialoDetails(){
		
		return (List<MaterialDetails>) materialDetailsRepository.findAll();
	}

}
