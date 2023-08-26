package com.project.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.ServersRepository;
import com.project.demo.Service.ServersService;
import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.Servers;
import com.project.demo.model.TechnicalStaffs;


@Service
public class ServersServiceImpl implements ServersService {
	
	@Autowired
	private ServersRepository serversRepository;
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService;
	
	
	public ServersServiceImpl(ServersRepository serversRepository) {
		super();
		this.serversRepository = serversRepository;
	}



	@Override
	public Servers saveServers(Servers servers,long id) {
		
		TechnicalStaffs technicalStaffs= technicalStaffsService.getTechnicalStaffsById(id);
		servers.setTechnicalStaffs(technicalStaffs);
		return serversRepository.save(servers);
	}
	
	@Override
	public Servers getServersById(long id,Servers servers) {
		
		return serversRepository.findById(id);
	}
	
	@Override
	public List<Servers> getAllServers(long id){
		
		return  serversRepository.findByTechnicalStaffsId(id);
	}
	
	@Override
	public Servers editServersById(long id,Servers servers) {
		
		Servers existingServers=serversRepository.findById(id);
		existingServers.setServerName(servers.getServerName());
		existingServers.setServerModelNo(servers.getServerModelNo());
		existingServers.setServerAssetNo(servers.getServerAssetNo());
		existingServers.setServerStatus(servers.getServerStatus());
		serversRepository.save(existingServers);
		return existingServers;
	}
	
	@Override
	public void deleteServersById(long id,Servers servers) {
		
		serversRepository.findById(id);
		 serversRepository.deleteById(id);
	}
	

}
