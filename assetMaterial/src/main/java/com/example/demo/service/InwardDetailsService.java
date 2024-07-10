package com.example.demo.service;

import java.util.List;



import com.example.demo.model.InwardDetails;

public interface InwardDetailsService {

	List<InwardDetails> addAllInwardDetails(List<InwardDetails> inwardDetails);

	List<InwardDetails> getAllInwardDetails();

}
