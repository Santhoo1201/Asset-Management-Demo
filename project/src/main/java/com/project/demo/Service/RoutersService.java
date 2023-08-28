package com.project.demo.Service;

import java.util.List;

import com.project.demo.model.Routers;

public interface RoutersService {
	
	Routers saveRouters(Routers routers,long id);
	List<Routers> getAllRouters(long id);
	Routers getRoutersById(long id,Routers routers);
	Routers editRoutersById(long id,Routers routers);
	void deleteRoutersById(long id,Routers routers);

}
