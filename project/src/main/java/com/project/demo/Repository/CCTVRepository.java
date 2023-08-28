package com.project.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.CCTV;

@Repository
public interface CCTVRepository extends JpaRepository <CCTV,Long>{
	
	CCTV findById(long id);
	List<CCTV> findByTechnicalStaffsId(long id);
	

}
