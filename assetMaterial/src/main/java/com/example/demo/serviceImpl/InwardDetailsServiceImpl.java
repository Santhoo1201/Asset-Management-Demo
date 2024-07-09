package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InwardDetails;
import com.example.demo.repository.InwardDetailsRepository;
import com.example.demo.service.InwardDetailsService;

@Service
public class InwardDetailsServiceImpl implements InwardDetailsService{
	
	@Autowired
	private InwardDetailsRepository inwardDetailsRepository;

	@Override
	public List<InwardDetails> addAllInwardDetails(List<InwardDetails> inwardDetails) {
		
		return inwardDetailsRepository.saveAll(inwardDetails);
	}

	@Override
	public List<InwardDetails> getAllInwardDetails() {
		
		return inwardDetailsRepository.findAllByOrderByReceiverDateDesc();
	}

}
