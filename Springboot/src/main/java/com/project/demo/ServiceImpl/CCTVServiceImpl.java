package com.project.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.CCTVRepository;
import com.project.demo.Service.CCTVService;
import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.CCTV;
import com.project.demo.model.TechnicalStaffs;


@Service
public class CCTVServiceImpl implements CCTVService {
	
	@Autowired
	private CCTVRepository cctvRepository;
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	public CCTVServiceImpl(CCTVRepository cctvRepository) {
		super();
		this.cctvRepository = cctvRepository;
	}

	@Override
	public CCTV saveCCTV(long id,CCTV cctv) {
		
		TechnicalStaffs technicalStaffs=technicalStaffsService.getTechnicalStaffsById(id);
		if(technicalStaffs != null) {
		cctv.setTechnicalStaffs(technicalStaffs);
		 cctvRepository.save(cctv);
		}
		return cctv;
		
	}

	@Override
	public List<CCTV> getALLCCTV(long id) {
	
		return cctvRepository.findByTechnicalStaffsId(id) ;
	}
	
	@Override
	public List<CCTV> getAll(){
		
		return cctvRepository.findAll();
	}
	
	
	

	@Override
	public CCTV getCCTVById(long id, CCTV cctv) {
		
		return cctvRepository.findById(id);
	}
	
	

}
