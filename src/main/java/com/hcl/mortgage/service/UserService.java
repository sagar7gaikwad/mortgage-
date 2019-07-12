package com.hcl.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.entity.PricePerSqFeet;
import com.hcl.mortgage.entity.User;
import com.hcl.mortgage.repository.LoanOfferRepository;
import com.hcl.mortgage.repository.PricePerSqFeetRepository;
import com.hcl.mortgage.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	PricePerSqFeetRepository pricePerSqFeetRepository;
	
	@Autowired
	UserRepository userRepositor;
	
	@Autowired
	LoanOfferRepository loanOfferRepository;
	
	/**
	 * This Method used to take user details and after calculating loan amount return the list oi offers available
	 *
	 * @param user takes user argument passed by controller
	 * @return returns the list of loan offers
	 */
	public List<LoanOffer> enquiryForLoan(User user) {
		
		  List<LoanOffer> offers = new ArrayList<>();
		
		  PricePerSqFeet price =
		  pricePerSqFeetRepository.findByPinCode(user.getPinCode()); 
		  
		  
		  Double propertyCost =
		  user.getAreaSize() * price.getRate(); 
		 
		  if(propertyCost >= 500000) {
			  
			  userRepositor.save(user); 
			  
			  double loanAmount = propertyCost *0.8;
			  			  
			  offers = loanOfferRepository.findByLoanAmount(loanAmount);
			 
			  return offers;
			 
		  }
		  
		return offers;
		  	 
		
	}

	

}
