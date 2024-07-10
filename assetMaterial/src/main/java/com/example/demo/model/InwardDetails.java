package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Inward_Details")
public class InwardDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long inwardId;
	
	@Column(name="Visitors")
	private String visitors;
	
	@Column(name="Visitors_SFM")
	private String visitorsSfm;
	
	@Column(name="Received_Sfm_By")
	private String receivedSfmBy;
	
	@Column(name="Verified_By")
	private String verifiedBy;
	
	@Column(name="From_Place")
	private String fromPlace;
	
	@Column(name="T0_Place")
	private String toPlace;
	
	@Column(name="Vehicle_Name")
	private String vehicleName;
	
	@Column(name="Receiver_Date")
	private String receiverDate;
	
	@Column(name="Material")
	private String material;
	
	@Column(name="Remark")
	private String remark; 
	
	public InwardDetails() {
		
	}

	public InwardDetails(long inwardId, String visitors, String visitorsSfm, String receivedSfmBy, String verifiedBy,
			String fromPlace, String toPlace, String vehicleName, String receiverDate, String material, String remark) {
		super();
		this.inwardId = inwardId;
		this.visitors = visitors;
		this.visitorsSfm = visitorsSfm;
		this.receivedSfmBy = receivedSfmBy;
		this.verifiedBy = verifiedBy;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.vehicleName = vehicleName;
		this.receiverDate = receiverDate;
		this.material = material;
		this.remark = remark;
	}

	public long getInwardId() {
		return inwardId;
	}

	public void setInwardId(long inwardId) {
		this.inwardId = inwardId;
	}

	public String getVisitors() {
		return visitors;
	}

	public void setVisitors(String visitors) {
		this.visitors = visitors;
	}

	public String getVisitorsSfm() {
		return visitorsSfm;
	}

	public void setVisitorsSfm(String visitorsSfm) {
		this.visitorsSfm = visitorsSfm;
	}

	public String getReceivedSfmBy() {
		return receivedSfmBy;
	}

	public void setReceivedSfmBy(String receivedSfmBy) {
		this.receivedSfmBy = receivedSfmBy;
	}

	public String getVerifiedBy() {
		return verifiedBy;
	}

	public void setVerifiedBy(String verifiedBy) {
		this.verifiedBy = verifiedBy;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getReceiverDate() {
		return receiverDate;
	}

	public void setReceiverDate(String receiverDate) {
		this.receiverDate = receiverDate;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	

}
