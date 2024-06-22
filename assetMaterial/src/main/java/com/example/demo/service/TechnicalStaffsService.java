package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TechnicalStaffs;

public interface TechnicalStaffsService {
	
	TechnicalStaffs saveTechnicalStaff(TechnicalStaffs technicalStaffs);
	
	TechnicalStaffs loginTechnicalStaff(TechnicalStaffs technicalStaffs);

	List<TechnicalStaffs> getAllTechnicalStaffs();

	TechnicalStaffs signUp(TechnicalStaffs technicalStaffs);

	TechnicalStaffs signIn(TechnicalStaffs technicalStaffs);
	
	TechnicalStaffs getTechnicalStaffsByEmailId(String sfmEmailId);
	

}
