package com.project.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.HrDetailsRepository;
import com.project.demo.Service.HrDetailsService;
import com.project.demo.model.HrDetails;



@Service
public class HrDetailsServiceImpl implements HrDetailsService {
	
	@Autowired
	private HrDetailsRepository hrDetailsRepository;
	
	public HrDetailsServiceImpl(HrDetailsRepository hrDetailsRepository) {
		super();
		this.hrDetailsRepository = hrDetailsRepository;
	}


	@Override
	public HrDetails saveHrDetails(HrDetails hrDetails) {
		
		return hrDetailsRepository.save(hrDetails);
	}
	
	
	@Override
	public HrDetails loginHrDetails(HrDetails hrDetails) {
		
		
		return this.hrDetailsRepository.findByHrEmailIdAndHrPassword(hrDetails.hrEmailId,hrDetails.hrPassword);
	}
	
	@Override
	public HrDetails getHrDetailsById(long id,HrDetails hrDetails) {
		
		
		return hrDetailsRepository.findById(id);
	}
	
	@Override
	public HrDetails editHrDetailsById(long id,HrDetails hrDetails) {
		
		HrDetails exixtingHrDetails= hrDetailsRepository.findById(id);
		exixtingHrDetails.setHrName(hrDetails.getHrName());
		exixtingHrDetails.setHrEmailId(hrDetails.getHrEmailId());
		exixtingHrDetails.setHrPassword(hrDetails.getHrPassword());
		exixtingHrDetails.setHrPhoneNo(hrDetails.getHrPhoneNo());
		hrDetailsRepository.save(exixtingHrDetails);
		return exixtingHrDetails;
	}
	

}
