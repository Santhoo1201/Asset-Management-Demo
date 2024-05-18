package com.example.demo.Service;

import java.io.Serializable;
import java.util.List;

//import com.example.demo.Controller.Wrapper;
import com.example.demo.Model.OutwardDetails;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectReader;





public interface OutWardDetailsService {

	OutwardDetails saveDetails(OutwardDetails outwardDetails);

	List<OutwardDetails> saveAllDetails(List<OutwardDetails> outwardDetails);



	OutwardDetails updateOutwardDetails(long outwardId, OutwardDetails outwardDetails);

	OutwardDetails getOutwardDetaisById(long id);

	List<OutwardDetails> getAllOutwardDetails();

	OutwardDetails getOutwardDetaisByAssetId(String assetId);

	OutwardDetails grtOutwardDetailsByModelId(String modelId);



}
