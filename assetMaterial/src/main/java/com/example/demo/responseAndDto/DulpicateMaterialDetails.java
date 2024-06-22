package com.example.demo.responseAndDto;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DulpicateMaterialDetails {
	
	private String assetNo;
	private String materialName;
	private String modelName;
	private String personName;
	private String outwardDate;
	private String assignedBy;
	
	public DulpicateMaterialDetails(String assetNo, String materialName, String modelName, String personName,
			String outwardDate, String assignedBy) {
		super();
		this.assetNo = assetNo;
		this.materialName = materialName;
		this.modelName = modelName;
		this.personName = personName;
		this.outwardDate = outwardDate;
		this.assignedBy = assignedBy;
	}
	public DulpicateMaterialDetails() {
		
	}
	public String getAssetNo() {
		return assetNo;
	}
	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getOutwardDate() {
		return outwardDate;
	}
	public void setOutwardDate(String outwardDate) {
		this.outwardDate = outwardDate;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	

}
