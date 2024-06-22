package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="outward_Details")
public class OutwardDetails  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long outwardId;
	
	@Column(name="Material")
	@JsonProperty
	private String material;
	
	@Column(name="RecieverSfm")
	@JsonProperty
	private String receiverSfm;
	
	@Column(name="AssignedSfm")
	@JsonProperty
	private String assignedSfm;
	
	
	@Column(name="From_Place")
//	@NotNull
	@JsonProperty
	private String fromPlace;
	
	@Column(name="To_Place")
//	@NotNull
	@JsonProperty
	private String toPlace;
	
	@Column(name="TravelV_Name")
//	@NotNull
	@JsonProperty
	private String travelV_Name;
	
	@Column(name="Remark",length=3000)
	@Size(max=45,message="Just 45 character only accepted")
//	@NotNull
	@JsonProperty
	private String remark;
	
	@Column(name="Approved_By")
//	@NotNull
	@JsonProperty
	private String approvedBy;
	
	
	@Column(name="Send_Date")
///	@DateTimeFormat(iso=ISO.DATE)
    @JsonProperty
//	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
	private String sendDate;


	public OutwardDetails(long outwardId, String material, String receiverSfm, String assignedSfm, String fromPlace,
			String toPlace, String travelV_Name,
			@Size(max = 45, message = "Just 45 character only accepted") String remark, String approvedBy,
			String sendDate) {
		super();
		this.outwardId = outwardId;
		this.material = material;
		this.receiverSfm = receiverSfm;
		this.assignedSfm = assignedSfm;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.travelV_Name = travelV_Name;
		this.remark = remark;
		this.approvedBy = approvedBy;
		this.sendDate = sendDate;
	}
	public OutwardDetails() {
		
	}
	public long getOutwardId() {
		return outwardId;
	}
	public void setOutwardId(long outwardId) {
		this.outwardId = outwardId;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getReceiverSfm() {
		return receiverSfm;
	}
	public void setReceiverSfm(String receiverSfm) {
		this.receiverSfm = receiverSfm;
	}
	public String getAssignedSfm() {
		return assignedSfm;
	}
	public void setAssignedSfm(String assignedSfm) {
		this.assignedSfm = assignedSfm;
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
	public String getTravelV_Name() {
		return travelV_Name;
	}
	public void setTravelV_Name(String travelV_Name) {
		this.travelV_Name = travelV_Name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}


		


	
	

}
