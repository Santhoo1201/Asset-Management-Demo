package com.project.demo.Service;

import com.project.demo.model.TechnicalStaffs;

public interface TechnicalStaffsService {
	
	
	TechnicalStaffs addStaffs(TechnicalStaffs technicalStaffs);
	TechnicalStaffs getTechnicalStaffsById(long id);
	TechnicalStaffs loginTechnicalStaffs(TechnicalStaffs technicalStaffs);

}
