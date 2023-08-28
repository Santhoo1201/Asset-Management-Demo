package com.project.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.TechnicalStaffsRepository;
import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.TechnicalStaffs;


@Service
public class TechnicalStaffsServiceImpl implements TechnicalStaffsService{
	
	@Autowired
	private TechnicalStaffsRepository technicalStaffsRepository;
	
	
	
	public TechnicalStaffsServiceImpl(TechnicalStaffsRepository technicalStaffsRepository) {
		super();
		this.technicalStaffsRepository = technicalStaffsRepository;
	}



	@Override
	public TechnicalStaffs addStaffs(TechnicalStaffs technicalStaffs) {
		
		return technicalStaffsRepository.save(technicalStaffs);
	}
	
	@Override
	public TechnicalStaffs getTechnicalStaffsById(long id) {
		
		return technicalStaffsRepository.findById(id);
	}
	
	@Override
	public TechnicalStaffs loginTechnicalStaffs(TechnicalStaffs technicalStaffs) {
		
		return this.technicalStaffsRepository.findByTechnicalStaffIdAndTechnicalStaffPassword(technicalStaffs.technicalStaffId,technicalStaffs.technicalStaffPassword);
	}

}
