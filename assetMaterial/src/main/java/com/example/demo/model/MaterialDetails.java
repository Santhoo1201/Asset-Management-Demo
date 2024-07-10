package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Material_Details")
public class MaterialDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long materialDetailsId;
	
	@Column(name="Material_AssetId")
	@JsonProperty
	private String materialAssetId;
	
	@Column(name="Material_Name")
	@JsonProperty
	private String materialName;
	
	@Column(name="Material_ModelId")
	@JsonProperty
	private String materialModelId;

	public MaterialDetails(long materialDetailsId, String materialAssetId, String materialName,
			String materialModelId) {
		super();
		this.materialDetailsId = materialDetailsId;
		this.materialAssetId = materialAssetId;
		this.materialName = materialName;
		this.materialModelId = materialModelId;
	}
	
	public MaterialDetails() {
		
	}

	public long getMaterialDetailsId() {
		return materialDetailsId;
	}

	public void setMaterialDetailsId(long materialDetailsId) {
		this.materialDetailsId = materialDetailsId;
	}

	public String getMaterialAssetId() {
		return materialAssetId;
	}

	public void setMaterialAssetId(String materialAssetId) {
		this.materialAssetId = materialAssetId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialModelId() {
		return materialModelId;
	}

	public void setMaterialModelId(String materialModelId) {
		this.materialModelId = materialModelId;
	}
	
	

}
