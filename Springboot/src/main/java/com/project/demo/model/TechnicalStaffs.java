package com.project.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="technicalstaffs_details")
public class TechnicalStaffs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="SFM_No")
	@NotEmpty
	public String technicalStaffId;
	
	@Column(name="Staff_Name")
	@NotEmpty
	private String technicalStaffName;
	
	@Column(name="Staff_Password")
	@NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String technicalStaffPassword;
	
	@Column(name="Staff_PhoneNo")
	@NotEmpty
	@Size(min=10 ,max=10 ,message="phoneNo must be contain 10 numbers")
	private String technicalStaffPhoneNo;
	
	@OneToMany(mappedBy="technicalStaffs",cascade=CascadeType.MERGE)
	@JsonIgnore
	public List<Printers> printers;
	
	@OneToMany(mappedBy="technicalStaffs",cascade=CascadeType.MERGE)
	@JsonIgnore
	public List<Routers> routers;
	
	@OneToMany(mappedBy="technicalStaffs",cascade=CascadeType.MERGE)
	@JsonIgnore
	public List<Servers> servers;
	
	@OneToMany(mappedBy="technicalStaffs",cascade=CascadeType.MERGE)
	@JsonIgnore
	public List<CCTV> cctv;
	
	public TechnicalStaffs() {
		
	}
	
	public TechnicalStaffs(long id, @NotEmpty String technicalStaffId, @NotEmpty String technicalStaffName,
			@NotEmpty @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}") String technicalStaffPassword,
			@NotEmpty @Size(min = 10, max = 10, message = "phoneNo must be contain 10 numbers") String technicalStaffPhoneNo,
			List<Printers> printers, List<Routers> routers, List<Servers> servers, List<CCTV> cctv) {
		super();
		this.id = id;
		this.technicalStaffId = technicalStaffId;
		this.technicalStaffName = technicalStaffName;
		this.technicalStaffPassword = technicalStaffPassword;
		this.technicalStaffPhoneNo = technicalStaffPhoneNo;
		this.printers = printers;
		this.routers = routers;
		this.servers = servers;
		this.cctv = cctv;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTechnicalStaffId() {
		return technicalStaffId;
	}

	public void setTechnicalStaffId(String technicalStaffId) {
		this.technicalStaffId = technicalStaffId;
	}

	public String getTechnicalStaffName() {
		return technicalStaffName;
	}

	public void setTechnicalStaffName(String technicalStaffName) {
		this.technicalStaffName = technicalStaffName;
	}

	public String getTechnicalStaffPassword() {
		return technicalStaffPassword;
	}

	public void setTechnicalStaffPassword(String technicalStaffPassword) {
		this.technicalStaffPassword = technicalStaffPassword;
	}

	public String getTechnicalStaffPhoneNo() {
		return technicalStaffPhoneNo;
	}

	public void setTechnicalStaffPhoneNo(String technicalStaffPhoneNo) {
		this.technicalStaffPhoneNo = technicalStaffPhoneNo;
	}

	public List<Printers> getPrinters() {
		return printers;
	}

	public void setPrinters(List<Printers> printers) {
		this.printers = printers;
	}

	public List<Routers> getRouters() {
		return routers;
	}

	public void setRouters(List<Routers> routers) {
		this.routers = routers;
	}

	public List<Servers> getServers() {
		return servers;
	}

	public void setServers(List<Servers> servers) {
		this.servers = servers;
	}

	public List<CCTV> getCctv() {
		return cctv;
	}

	public void setCctv(List<CCTV> cctv) {
		this.cctv = cctv;
	}







	
	
}
