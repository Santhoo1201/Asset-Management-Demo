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
@Table(name="Routers_Details")
public class Routers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long routerId;
	
	@Column(name="Router_Name")
	@NotEmpty
	private String routerName;
	
	@Column(name="Router_ModelNo")
	@NotEmpty		
	private String routerModelNo;
	
	@Column(name="Router_AssetNo")
	@NotEmpty
	private String routerAssetNo;
	
	@Column(name="Router_Status")
	@NotEmpty
	private String routerStatus;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id")
	@JsonIgnore
	private TechnicalStaffs technicalStaffs;
	
	
	
	public Routers(long routerId, @NotEmpty String routerName, @NotEmpty String routerModelNo,
			@NotEmpty String routerAssetNo, @NotEmpty String routerStatus, TechnicalStaffs technicalStaffs) {
		super();
		this.routerId = routerId;
		this.routerName = routerName;
		this.routerModelNo = routerModelNo;
		this.routerAssetNo = routerAssetNo;
		this.routerStatus = routerStatus;
		this.technicalStaffs = technicalStaffs;
	}


	public Routers() {
		
	}


	public long getRouterId() {
		return routerId;
	}


	public void setRouterId(long routerId) {
		this.routerId = routerId;
	}


	public String getRouterName() {
		return routerName;
	}


	public void setRouterName(String routerName) {
		this.routerName = routerName;
	}


	public String getRouterModelNo() {
		return routerModelNo;
	}


	public void setRouterModelNo(String routerModelNo) {
		this.routerModelNo = routerModelNo;
	}


	public String getRouterAssetNo() {
		return routerAssetNo;
	}


	public void setRouterAssetNo(String routerAssetNo) {
		this.routerAssetNo = routerAssetNo;
	}


	public String getRouterStatus() {
		return routerStatus;
	}


	public void setRouterStatus(String routerStatus) {
		this.routerStatus = routerStatus;
	}


	public TechnicalStaffs getTechnicalStaffs() {
		return technicalStaffs;
	}


	public void setTechnicalStaffs(TechnicalStaffs technicalStaffs) {
		this.technicalStaffs = technicalStaffs;
	}
	
	
	
	

}
