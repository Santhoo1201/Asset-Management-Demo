package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.TechnicalStaffs;

public interface TechnicalStaffsService {
	
	TechnicalStaffs saveTechnicalStaff(TechnicalStaffs technicalStaffs);
	
	TechnicalStaffs loginTechnicalStaff(TechnicalStaffs technicalStaffs);

	List<TechnicalStaffs> getAllTechnicalStaffs();
	

}
