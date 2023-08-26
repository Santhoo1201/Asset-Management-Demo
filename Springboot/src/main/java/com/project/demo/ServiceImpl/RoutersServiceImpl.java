package com.project.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.RoutersRepository;
import com.project.demo.Service.RoutersService;
import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.Routers;
import com.project.demo.model.TechnicalStaffs;


@Service
public class RoutersServiceImpl implements RoutersService {
	
	
	@Autowired
	private RoutersRepository routersRepository;
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	
	public RoutersServiceImpl(RoutersRepository routersRepository) {
		super();
		this.routersRepository = routersRepository;
	}




	@Override
	public Routers saveRouters(Routers routers,long id) {
		
		
		TechnicalStaffs technicalStaffs= technicalStaffsService.getTechnicalStaffsById(id);
		routers.setTechnicalStaffs(technicalStaffs);
		return routersRepository.save(routers);
	}
	
	@Override
	public List<Routers> getAllRouters(long id){
		
		
		return routersRepository.findByTechnicalStaffsId(id);
	}
	
	@Override
	public Routers getRoutersById(long id,Routers routers) {
		
		
		return routersRepository.findById(id);
	}
	
	@Override
	public Routers editRoutersById(long id,Routers routers) {
		
		Routers existingRouters=routersRepository.findById(id);
		existingRouters.setRouterName(routers.getRouterName());
		existingRouters.setRouterModelNo(routers.getRouterModelNo());
		existingRouters.setRouterAssetNo(routers.getRouterAssetNo());
		existingRouters.setRouterStatus(routers.getRouterStatus());
		routersRepository.save(existingRouters);
		return existingRouters;
	}
	
	@Override
	public void deleteRoutersById(long id,Routers routers) {
		
		routersRepository.findById(id);
		routersRepository.deleteById(id);
	}

}
