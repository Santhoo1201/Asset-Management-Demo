package com.project.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Hr_Details")
public class HrDetails {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Hr_Id")
	private long hrId;
	
	@Column(name="Hr_Name")
	@NotEmpty
	private String hrName;
	
	@Column(name="Hr_EmailId",unique=true)
	@NotEmpty
	public String hrEmailId;
	
	@Column(name="Hr_Password")
	@NotEmpty
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String hrPassword;
	
	@Column(name="Hr_PhoneNo")
	@NotEmpty
	@Size(min=10,max=10,message="PhoneNo must be contain 10 numbers")
	private String hrPhoneNo;
	
	public HrDetails() {
		
	}
	
	public HrDetails(long hrId, String hrName, String hrEmailId, String hrPassword, String hrPhoneNo) {
		super();
		this.hrId = hrId;
		this.hrName = hrName;
		this.hrEmailId = hrEmailId;
		this.hrPassword = hrPassword;
		this.hrPhoneNo = hrPhoneNo;
	}
	public long getHrId() {
		return hrId;
	}
	public void setHrId(long hrId) {
		this.hrId = hrId;
	}
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getHrEmailId() {
		return hrEmailId;
	}
	public void setHrEmailId(String hrEmailId) {
		this.hrEmailId = hrEmailId;
	}
	public String getHrPassword() {
		return hrPassword;
	}
	public void setHrPassword(String hrPassword) {
		this.hrPassword = hrPassword;
	}
	public String getHrPhoneNo() {
		return hrPhoneNo;
	}
	public void setHrPhoneNo(String hrPhoneNo) {
		this.hrPhoneNo = hrPhoneNo;
	}
	
	
	

}
