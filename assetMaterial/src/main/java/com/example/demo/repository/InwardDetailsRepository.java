package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.InwardDetails;

public interface InwardDetailsRepository extends JpaRepository<InwardDetails,Long>{

	List<InwardDetails> findAllByOrderByReceiverDateDesc();

}
