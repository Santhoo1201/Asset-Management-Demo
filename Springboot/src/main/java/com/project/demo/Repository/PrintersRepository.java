package com.project.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.model.Printers;

public interface PrintersRepository  extends JpaRepository <Printers,Long> {
	
	Printers findById(long id);
	List<Printers> findByTechnicalStaffsId(long id);
	

}
