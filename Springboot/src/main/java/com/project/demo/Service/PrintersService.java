package com.project.demo.Service;

import java.util.List;

import com.project.demo.model.Printers;

public interface PrintersService {
	
	
	Printers savePrinters(Printers printers,long id);
	Printers getPrintersById(long id,Printers printers);
	List<Printers> getAllPrinters(long id);
	Printers editPrinters(long id,Printers printers);
	void deletePrinters(long id,Printers printers);
	

}
