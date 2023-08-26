package com.project.demo.Service;

import java.util.List;

import com.project.demo.model.Servers;

public interface ServersService {
	
	Servers saveServers(Servers servers,long id);
	Servers getServersById(long id,Servers servers);
	List<Servers> getAllServers(long id);
	Servers editServersById(long id,Servers servers);
	void deleteServersById(long id,Servers servers);

}
