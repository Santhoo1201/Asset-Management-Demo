package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TechnicalStaffs;

public interface TechnicalStaffsRepository extends JpaRepository<TechnicalStaffs,Long> {
	
	TechnicalStaffs findBySfmEmailIdAndSfmPassword(String sfmEmailId,String sfmPassword);

	TechnicalStaffs findBySfmEmailId(String sfmEmailId);

}
