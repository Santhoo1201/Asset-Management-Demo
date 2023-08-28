package com.project.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Routers;

public interface RoutersRepository extends JpaRepository <Routers,Long>{
	
	
	Routers findById(long id);
	List<Routers> findByTechnicalStaffsId(long id);
	

}
