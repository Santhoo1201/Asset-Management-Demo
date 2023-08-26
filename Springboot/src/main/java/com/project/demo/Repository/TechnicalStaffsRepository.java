package com.project.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.TechnicalStaffs;

public interface TechnicalStaffsRepository extends JpaRepository <TechnicalStaffs,Long> {
	
	
	TechnicalStaffs findById(long id);
	TechnicalStaffs findByTechnicalStaffIdAndTechnicalStaffPassword(String id,String password);
	

}
