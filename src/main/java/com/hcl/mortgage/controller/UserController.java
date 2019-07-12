package com.hcl.mortgage.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.entity.User;
import com.hcl.mortgage.service.UserService;

@RestController
@RequestMapping("/enquiry")
public class UserController {

	@Autowired
	UserService userService;
	
	
	/**This method returns loan offer after calculating the property value and 80% of loan amount
	 * @param user get user details from user
	 * @return returns the list of available for that particular user
	 */
	@PostMapping("/mortgageOffer")
	public ResponseEntity<Object> enquiryForLoan(@RequestBody User user) {

		
		
	int age =  Period.between(user.getUserDOB(), LocalDate.now()).getYears();
	
		
		  if(age > 25 && user.getSalary() >=10000 ) {
		  
		  List<LoanOffer> offers = userService.enquiryForLoan(user); return new
		  ResponseEntity <>(offers, HttpStatus.OK);
		  
		  }
		 
		return new ResponseEntity<>("Not Eligible ", HttpStatus.OK);
	}

}
