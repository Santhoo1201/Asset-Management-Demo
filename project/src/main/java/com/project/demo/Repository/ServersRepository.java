package com.project.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Servers;

public interface ServersRepository extends JpaRepository<Servers,Long> {
	
	Servers findById(long id);
	List<Servers> findByTechnicalStaffsId(long id);
	

}
