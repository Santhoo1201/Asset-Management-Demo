package com.project.demo.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.HrDetails;

public interface HrDetailsRepository extends JpaRepository <HrDetails,Long>{
	
	HrDetails findByHrEmailIdAndHrPassword(String emailId,String password);
	HrDetails findById(long id);
	

}
