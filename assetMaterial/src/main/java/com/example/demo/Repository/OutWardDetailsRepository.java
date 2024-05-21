package com.example.demo.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.OutwardDetails;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectReader;



public interface OutWardDetailsRepository extends JpaRepository<OutwardDetails,Long> {

//	OutwardDetails findByAssetId (String assetId);

	OutwardDetails findByOutwardId(long outwardId);
	
//	OutwardDetails findById(long id);
//
//	List<OutwardDetails> findAllByOutWardDetailsModelId(String modelId);//modelNo
//
//	OutwardDetails findByModelId(String modelId);

//	List<OutwardDetails> findAllByOutwardIdDesc();

//	List<OutwardDetails> findFirstByOutwardIdDesc();

	List<OutwardDetails> findAllByOrderBySendDateDesc();

//	List<OutwardDetails> findFirstByOutwardIdDesc1();

//	List<OutwardDetails> saveAllOutwardDetails(ObjectReader outwardDetails);
//
//	List<OutwardDetails> saveAll(Serializable outwardDetails);
//
////	List<OutwardDetails> saveAll(ObjectReader outwardDetails);

}
