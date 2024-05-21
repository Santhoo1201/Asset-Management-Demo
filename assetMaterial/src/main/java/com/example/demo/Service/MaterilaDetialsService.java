package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.MaterialDetails;

import jakarta.validation.Valid;

public interface MaterilaDetialsService {

	List<MaterialDetails> getAllMaterialoDetails();

	List<MaterialDetails> saveAllMaterialDetails(@Valid List<MaterialDetails> materialDetails);

	MaterialDetails saveMaterialDetails(@Valid MaterialDetails materialDetails);

}
