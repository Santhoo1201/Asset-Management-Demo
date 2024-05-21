package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="TechnicalStaffs")
public class TechnicalStaffs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long technicalStaffId;
	
	@Column(name="SFM_Id")
	@NotEmpty
	private String sfmId;
	
	@Column(name="SFM_Name")
	@NotEmpty
	private String sfmName;
	
	@Column(name="Sfm_Role")
	@NotEmpty
	private String  sfmRole;
	
	@Column(name="SFM_PhoneNo")
	@NotEmpty
	@Size(min=10,max=10,message="Phone number must be contain 10 number")
	private String sfmPhoneNo;
	
	@Column(name="SFM_EmailId",unique=true)
	@Email
	@NotEmpty
	public String sfmEmailId;
	
	@Column(name="SFM_Password")
	@NotEmpty
	public String sfmPassword;
	
	
	public TechnicalStaffs(long technicalStaffId, @NotEmpty String sfmId, @NotEmpty String sfmName,
			@NotEmpty String sfmRole,
			@NotEmpty @Size(min = 10, max = 10, message = "Phone number must be contain 10 number") String sfmPhoneNo,
			@Email @NotEmpty String sfmEmailId, @NotEmpty String sfmPassword) {
		super();
		this.technicalStaffId = technicalStaffId;
		this.sfmId = sfmId;
		this.sfmName = sfmName;
		this.sfmRole = sfmRole;
		this.sfmPhoneNo = sfmPhoneNo;
		this.sfmEmailId = sfmEmailId;
		this.sfmPassword = sfmPassword;
	}

	public TechnicalStaffs() {
		
	}

	public long getTechnicalStaffId() {
		return technicalStaffId;
	}

	public void setTechnicalStaffId(long technicalStaffId) {
		this.technicalStaffId = technicalStaffId;
	}

	public String getSfmId() {
		return sfmId;
	}

	public void setSfmId(String sfmId) {
		this.sfmId = sfmId;
	}

	public String getSfmName() {
		return sfmName;
	}

	public void setSfmName(String sfmName) {
		this.sfmName = sfmName;
	}

	public String getSfmRole() {
		return sfmRole;
	}

	public void setSfmRole(String sfmRole) {
		this.sfmRole = sfmRole;
	}

	public String getSfmPhoneNo() {
		return sfmPhoneNo;
	}

	public void setSfmPhoneNo(String sfmPhoneNo) {
		this.sfmPhoneNo = sfmPhoneNo;
	}

	public String getSfmEmailId() {
		return sfmEmailId;
	}

	public void setSfmEmailId(String sfmEmailId) {
		this.sfmEmailId = sfmEmailId;
	}

	public String getSfmPassword() {
		return sfmPassword;
	}

	public void setSfmPassword(String sfmPassword) {
		this.sfmPassword = sfmPassword;
	}

		
	

}
