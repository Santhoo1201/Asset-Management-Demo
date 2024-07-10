package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OutwardDetails;
import com.example.demo.repository.OutWardDetailsRepository;
import com.example.demo.service.OutWardDetailsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;


@Service
public class OutWardDetailsServiceImpl implements OutWardDetailsService {
	
	@Autowired
	private OutWardDetailsRepository outWardDetailsRepository;

	public OutWardDetailsServiceImpl(OutWardDetailsRepository outWardDetailsRepository) {
		super();
		this.outWardDetailsRepository = outWardDetailsRepository;
	}
	
	@Override
	public OutwardDetails saveDetails(OutwardDetails outwardDetails) {
		
		return outWardDetailsRepository.save(outwardDetails);
	}
	
	@Override
	public List<OutwardDetails> saveAllDetails(List<OutwardDetails> outwardDetails){
		
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		
//		Collection<OutwardDetails> readValues = new ObjectMapper().readValue(
//			    jsonAsString, new TypeReference<Collection<OutwardDetails>>() { }
//			);
		
		List<OutwardDetails> getAndSetValue= new ArrayList<OutwardDetails>();
		for(OutwardDetails dummy : outwardDetails) {
//			dummy.setAssignedBy(((OutwardDetails) outwardDetails).getAssignedBy());
//			dummy.setAssignerSFMId(((OutwardDetails) outwardDetails).getAssignerSFMId());
//			dummy.setApprovedBy(((OutwardDetails) outwardDetails).getApprovedBy());
//			dummy.setReceiverMobileNo(((OutwardDetails) outwardDetails).getReceiverMobileNo());
//			dummy.setReceiverSFMId(((OutwardDetails) outwardDetails).getReceiverSFMId());
//			dummy.setReceiverName(((OutwardDetails) outwardDetails).getReceiverName());			
//			dummy.setFromPlace(((OutwardDetails) outwardDetails).getFromPlace());
//			dummy.setToPlace(((OutwardDetails) outwardDetails).getToPlace());
//			dummy.setTravelV_Name(((OutwardDetails) outwardDetails).getTravelV_Name());
//			dummy.setSendDate(((OutwardDetails) outwardDetails).getSendDate());
//		dummy.setRemark(((OutwardDetails) outwardDetails).getRemark());
		
		getAndSetValue.add(dummy);			
	}
	
		return ( List<OutwardDetails>) outWardDetailsRepository.saveAll(getAndSetValue);
	}
	
//	@Override
//	public OutwardDetails getOutwardDetaisByAssetId(String assetId) {
//		
////		List<OutwardDetails> persent= outWardDetailsRepository.findByAssetId(assetId);
////		if(persent == null) {
////			return null;
////		}
//		return outWardDetailsRepository.findByAssetId(assetId);
//	}
	
	@Override
	public OutwardDetails updateOutwardDetails(long outwardId, OutwardDetails outwardDetails) {
		
		OutwardDetails existingValue=outWardDetailsRepository.findByOutwardId(outwardId);
		existingValue.setMaterial(outwardDetails.getMaterial());
		existingValue.setAssignedSfm(outwardDetails.getAssignedSfm());
		existingValue.setReceiverSfm(outwardDetails.getReceiverSfm());
		existingValue.setFromPlace(outwardDetails.getFromPlace());
		existingValue.setToPlace(outwardDetails.getToPlace());
		existingValue.setSendDate(outwardDetails.getSendDate());
		existingValue.setTravelV_Name(outwardDetails.getTravelV_Name());
		existingValue.setRemark(outwardDetails.getRemark());
		existingValue.setApprovedBy(outwardDetails.getApprovedBy());
		
		
		return outWardDetailsRepository.save(existingValue);
	}
	
	@Override
	public OutwardDetails getOutwardDetaisById(long id) {
		
		return outWardDetailsRepository.findByOutwardId(id);
	}
	
	@Override
	public List<OutwardDetails> getAllOutwardDetails(){
		
		return outWardDetailsRepository.findAllByOrderBySendDateDesc();//which are they record is added to get All record in descending order(Reverse order)with current(Latest added record) date
	}
	
//	@Override
//	public OutwardDetails grtOutwardDetailsByModelId(String modelId) {
//		
//		return  outWardDetailsRepository.findByModelId(modelId);
//	}

}
