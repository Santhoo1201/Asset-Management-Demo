package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.TechnicalStaffs;
import com.example.demo.repository.TechnicalStaffsRepository;
import com.example.demo.service.TechnicalStaffsService;

@Service
public class TechnicalStaffsServiceImpl implements TechnicalStaffsService{
	
	@Autowired
	private TechnicalStaffsRepository technicalStaffsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private AuthenticationManager authenticationManager;

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
	
	@Override
	public List<TechnicalStaffs> getAllTechnicalStaffs(){
		
		return technicalStaffsRepository.findAll();
	}

	@Override
	public TechnicalStaffs signUp(TechnicalStaffs technicalStaffs) {
		
		technicalStaffs.setSfmPassword(passwordEncoder.encode(technicalStaffs.getSfmPassword()));
	
		return technicalStaffsRepository.save(technicalStaffs);
	}

	@Override
	public TechnicalStaffs signIn(TechnicalStaffs technicalStaffs) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(technicalStaffs.getSfmEmailId(),technicalStaffs.getSfmPassword()));
		System.out.println("In step ");
		TechnicalStaffs gettingStaffs = technicalStaffsRepository.findBySfmEmailId(technicalStaffs.getSfmEmailId());
		return gettingStaffs;
	}

	@Override
	public TechnicalStaffs getTechnicalStaffsByEmailId(String sfmEmailId) {
		
		return technicalStaffsRepository.findBySfmEmailId(sfmEmailId);
	}

}
