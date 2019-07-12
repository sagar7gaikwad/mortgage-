package com.hcl.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_offer")
public class LoanOffer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "loan_amount")
	private Double loanAmount;
	
	@Column(name = "loan_tenure")
	private Integer loanTenuare;
	
	@Column(name="interest_rate")
	private Double interestRate;
	
	@Column(name="emi")
	private Long emi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanTenuare() {
		return loanTenuare;
	}

	public void setLoanTenuare(Integer loanTenuare) {
		this.loanTenuare = loanTenuare;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Long getEmi() {
		return emi;
	}

	public void setEmi(Long emi) {
		this.emi = emi;
	}
	
}
