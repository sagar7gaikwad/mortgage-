package com.hcl.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.PricePerSqFeet;

@Repository
public interface PricePerSqFeetRepository extends JpaRepository<PricePerSqFeet, Integer>{
	
	@Query(value="select * from price_per_sq_feet where pincode =?1" , nativeQuery = true)
	PricePerSqFeet findByPinCode(int pinCode);

	
	
}
