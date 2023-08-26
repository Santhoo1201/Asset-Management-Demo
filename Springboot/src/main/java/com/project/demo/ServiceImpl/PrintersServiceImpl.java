package com.project.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.Repository.PrintersRepository;
import com.project.demo.Service.PrintersService;
import com.project.demo.Service.TechnicalStaffsService;
import com.project.demo.model.Printers;
import com.project.demo.model.TechnicalStaffs;

@Service
public class PrintersServiceImpl  implements PrintersService {
	
	
	@Autowired
	private PrintersRepository printersRepository;
	
	@Autowired
	private TechnicalStaffsService technicalStaffsService ;
	
	
	public PrintersServiceImpl(PrintersRepository printersRepository) {
		super();
		this.printersRepository = printersRepository;
	}



	@Override
	public Printers savePrinters(Printers printers,long id) {
		
		
		TechnicalStaffs technicalStaffs= technicalStaffsService.getTechnicalStaffsById(id);
		printers.setTechnicalStaffs(technicalStaffs);
		return printersRepository.save(printers);
		
	}
	
	@Override
	public Printers getPrintersById(long id,Printers printers) {
		
		return printersRepository.findById(id);
	}
	
	@Override
	public List<Printers> getAllPrinters(long id){
		
		
		return printersRepository.findByTechnicalStaffsId(id);
	}
	
	@Override
	public Printers editPrinters(long id,Printers printers) {
		
		Printers existingPrinters=printersRepository.findById(id);
		existingPrinters.setPrinterName(printers.getPrinterName());
		existingPrinters.setPrinterModelNo(printers.getPrinterModelNo());
		existingPrinters.setPrinterAssetNo(printers.getPrinterAssetNo());
		existingPrinters.setPrinterStatus(printers.getPrinterStatus());
		printersRepository.save(existingPrinters);
		return existingPrinters;
	}
	
	@Override
	public void  deletePrinters(long id,Printers printers) {
		
		
		printersRepository.findById(id);
		printersRepository.deleteById(id);
	}
	
	

}
