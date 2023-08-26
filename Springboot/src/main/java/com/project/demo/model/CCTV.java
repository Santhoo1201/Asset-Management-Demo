package com.project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="cctv_Details")
public class CCTV {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cctv_Id")
	private long id;
	
	@Column(name="cctv_Name")
	@NotEmpty
	private String cctvName;
	
	@Column(name="cctv_AssetNo")
	@NotEmpty
	private String cctvAssetNo;
	
	@Column(name="cctv_ModelNo")
	@NotEmpty
	private String cctvModelNo;
	
	@Column(name="cctv_Status")
	@NotEmpty
	private String cctvStatus;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="SFM_No")
	@JsonIgnore
	private TechnicalStaffs technicalStaffs;
	
	
	public CCTV() {
		
	}


	public CCTV(long id, @NotEmpty String cctvName, @NotEmpty String cctvAssetNo, @NotEmpty String cctvModelNo,
			@NotEmpty String cctvStatus, TechnicalStaffs technicalStaffs) {
		super();
		this.id = id;
		this.cctvName = cctvName;
		this.cctvAssetNo = cctvAssetNo;
		this.cctvModelNo = cctvModelNo;
		this.cctvStatus = cctvStatus;
		this.technicalStaffs = technicalStaffs;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCctvName() {
		return cctvName;
	}


	public void setCctvName(String cctvName) {
		this.cctvName = cctvName;
	}


	public String getCctvAssetNo() {
		return cctvAssetNo;
	}


	public void setCctvAssetNo(String cctvAssetNo) {
		this.cctvAssetNo = cctvAssetNo;
	}


	public String getCctvModelNo() {
		return cctvModelNo;
	}


	public void setCctvModelNo(String cctvModelNo) {
		this.cctvModelNo = cctvModelNo;
	}


	public String getCctvStatus() {
		return cctvStatus;
	}


	public void setCctvStatus(String cctvStatus) {
		this.cctvStatus = cctvStatus;
	}


	public TechnicalStaffs getTechnicalStaffs() {
		return technicalStaffs;
	}


	public void setTechnicalStaffs(TechnicalStaffs technicalStaffs) {
		this.technicalStaffs = technicalStaffs;
	}
	
	
	

}
