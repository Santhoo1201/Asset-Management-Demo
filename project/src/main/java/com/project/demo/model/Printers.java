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
@Table(name="Printers_Details")
public class Printers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long printerId;
	
	@Column(name="Printer_Name")
	@NotEmpty
	private String printerName;
	
	@Column(name="Printer_ModelNo")
	@NotEmpty
	private String printerModelNo;
	
	@Column(name="Printer_AssetNo")
	@NotEmpty
	private String printerAssetNo;
	
	@Column(name="Printer_Status")
	@NotEmpty
	private String printerStatus;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id")
	@JsonIgnore
	private  TechnicalStaffs technicalStaffs; 
	
	public Printers() {
		
	}
	

	public Printers(long printerId, @NotEmpty String printerName, @NotEmpty String printerModelNo,
			@NotEmpty String printerAssetNo, @NotEmpty String printerStatus, TechnicalStaffs technicalStaffs) {
		super();
		this.printerId = printerId;
		this.printerName = printerName;
		this.printerModelNo = printerModelNo;
		this.printerAssetNo = printerAssetNo;
		this.printerStatus = printerStatus;
		this.technicalStaffs = technicalStaffs;
	}




	public long getPrinterId() {
		return printerId;
	}

	public void setPrinterId(long printerId) {
		this.printerId = printerId;
	}

	public String getPrinterName() {
		return printerName;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public String getPrinterModelNo() {
		return printerModelNo;
	}

	public void setPrinterModelNo(String printerModelNo) {
		this.printerModelNo = printerModelNo;
	}

	public String getPrinterAssetNo() {
		return printerAssetNo;
	}

	public void setPrinterAssetNo(String printerAssetNo) {
		this.printerAssetNo = printerAssetNo;
	}

	public String getPrinterStatus() {
		return printerStatus;
	}

	public void setPrinterStatus(String printerStatus) {
		this.printerStatus = printerStatus;
	}

	public TechnicalStaffs getTechnicalStaffs() {
		return technicalStaffs;
	}

	public void setTechnicalStaffs(TechnicalStaffs technicalStaffs) {
		this.technicalStaffs = technicalStaffs;
	}
	
	
	
	

}
