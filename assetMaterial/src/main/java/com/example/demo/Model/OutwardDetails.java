package com.example.demo.Model;

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
	
	@Column(name="Asset_Id")
//	@NotNull
	@JsonProperty
	private String assetId;
	
	@Column(name="Material_Name")
//	@NotNull
	@JsonProperty
	private String materialName;
	
	@Column(name="Model_No")
//	@NotNull
	@JsonProperty
	private String modelId;
	
	@Column(name="Assigned_By")
//	@NotNull
	@JsonProperty
	private String assignedBy;
	
	@Column(name="Assigner_SFMId")
//	@NotNull
	@JsonProperty
	private String assignerSFMId;
	
	@Column(name="Receiver_MobileNo")
	@Size(min=10,max=10,message="The Mobile Number should be contain 10 number")
//	@NotNull
	@JsonProperty
	private String receiverMobileNo;
	
	@Column(name="Receiver_SFMId")
//	@NotNull
	@JsonProperty
	private String receiverSFMId;
	
	@Column(name="Receiver_Name")
//	@NotNull
	@JsonProperty
	private String receiverName;
	
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
//	@DateTimeFormat(iso=ISO.DATE)
	@JsonProperty
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
	private LocalDateTime sendDate;


	public OutwardDetails(long outwardId, String assetId, String materialName, String modelId, String assignedBy,
			String assignerSFMId,
			@Size(min = 10, max = 10, message = "The Mobile Number should be contain 10 number") String receiverMobileNo,
			String receiverSFMId, String receiverName, String fromPlace, String toPlace, String travelV_Name,
			@Size(max = 45, message = "Just 45 character only accepted") String remark, String approvedBy,
			LocalDateTime sendDate) {
		super();
		this.outwardId = outwardId;
		this.assetId = assetId;
		this.materialName = materialName;
		this.modelId = modelId;
		this.assignedBy = assignedBy;
		this.assignerSFMId = assignerSFMId;
		this.receiverMobileNo = receiverMobileNo;
		this.receiverSFMId = receiverSFMId;
		this.receiverName = receiverName;
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
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getAssignerSFMId() {
		return assignerSFMId;
	}
	public void setAssignerSFMId(String assignerSFMId) {
		this.assignerSFMId = assignerSFMId;
	}
	public String getReceiverMobileNo() {
		return receiverMobileNo;
	}
	public void setReceiverMobileNo(String receiverMobileNo) {
		this.receiverMobileNo = receiverMobileNo;
	}
	public String getReceiverSFMId() {
		return receiverSFMId;
	}
	public void setReceiverSFMId(String receiverSFMId) {
		this.receiverSFMId = receiverSFMId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
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
	public LocalDateTime getSendDate() {
		return sendDate;
	}
	public void setSendDate(LocalDateTime sendDate) {
		this.sendDate = sendDate;
	}


	


	
	

}
