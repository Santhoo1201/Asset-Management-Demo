package com.project.demo.Service;

import java.util.List;

import com.project.demo.model.CCTV;

public interface CCTVService {
	
	
	CCTV saveCCTV(long id,CCTV cctv);
	List<CCTV> getALLCCTV(long id);
	CCTV getCCTVById(long id,CCTV cctv);
	List<CCTV> getAll();

}
