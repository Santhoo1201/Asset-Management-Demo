package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.TechnicalStaffs;

public interface TechnicalStaffsRepository extends JpaRepository<TechnicalStaffs,Long> {
	
	TechnicalStaffs findBySfmEmailIdAndSfmPassword(String sfmEmailId,String sfmPassword);

}
