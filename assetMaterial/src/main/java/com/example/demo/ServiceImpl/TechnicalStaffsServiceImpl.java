package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.TechnicalStaffs;
import com.example.demo.Repository.TechnicalStaffsRepository;
import com.example.demo.Service.TechnicalStaffsService;

@Service
public class TechnicalStaffsServiceImpl implements TechnicalStaffsService{
	
	@Autowired
	private TechnicalStaffsRepository technicalStaffsRepository;

	public TechnicalStaffsServiceImpl(TechnicalStaffsRepository technicalStaffsRepository) {
		super();
		this.technicalStaffsRepository = technicalStaffsRepository;
	}
	
	@Override
	public TechnicalStaffs saveTechnicalStaff(TechnicalStaffs technicalStaffs) {
		
		return  technicalStaffsRepository.save(technicalStaffs);
	}
	
	@Override
	public TechnicalStaffs loginTechnicalStaff(TechnicalStaffs technicalStaffs) {
		
//		TechnicalStaffs dummy= technicalStaffsRepository.findBySfmEmailIdAndSfmPassword(technicalStaffs.sfmEmailId,technicalStaffs.sfmPassword);
//		if(dummy.getSfmEmailId()==null && dummy.getSfmPassword()==null) {
//			return null;
//		}
		return this. technicalStaffsRepository.findBySfmEmailIdAndSfmPassword(technicalStaffs.sfmEmailId,technicalStaffs.sfmPassword);
	}

}
