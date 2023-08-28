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
@Table(name="Servers_Details")
public class Servers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long serverId;
	
	@Column(name="Server_Name")
	@NotEmpty
	private String serverName;
	
	@Column(name="Server_ModelNo")
	@NotEmpty
	private String serverModelNo;
	
	@Column(name="Server_AssetNo")
	@NotEmpty
	private String serverAssetNo;
	
	@Column(name="Server_Status")
	@NotEmpty
	private String serverStatus;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id")
	@JsonIgnore
	private TechnicalStaffs technicalStaffs;
	
	
	public Servers() {
		
	}
	
	
	
	
	public Servers(long serverId, @NotEmpty String serverName, @NotEmpty String serverModelNo,
			@NotEmpty String serverAssetNo, @NotEmpty String serverStatus, TechnicalStaffs technicalStaffs) {
		super();
		this.serverId = serverId;
		this.serverName = serverName;
		this.serverModelNo = serverModelNo;
		this.serverAssetNo = serverAssetNo;
		this.serverStatus = serverStatus;
		this.technicalStaffs = technicalStaffs;
	}




	public long getServerId() {
		return serverId;
	}




	public void setServerId(long serverId) {
		this.serverId = serverId;
	}




	public String getServerName() {
		return serverName;
	}




	public void setServerName(String serverName) {
		this.serverName = serverName;
	}




	public String getServerModelNo() {
		return serverModelNo;
	}




	public void setServerModelNo(String serverModelNo) {
		this.serverModelNo = serverModelNo;
	}




	public String getServerAssetNo() {
		return serverAssetNo;
	}




	public void setServerAssetNo(String serverAssetNo) {
		this.serverAssetNo = serverAssetNo;
	}




	public String getServerStatus() {
		return serverStatus;
	}




	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}




	public TechnicalStaffs getTechnicalStaffs() {
		return technicalStaffs;
	}




	public void setTechnicalStaffs(TechnicalStaffs technicalStaffs) {
		this.technicalStaffs = technicalStaffs;
	}




	
	

}
