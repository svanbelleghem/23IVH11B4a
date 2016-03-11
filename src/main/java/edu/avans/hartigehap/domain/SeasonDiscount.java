package edu.avans.hartigehap.domain;

import java.util.Date;

public class SeasonDiscount implements Discount {

	public Date periodstart;
	public Date periodend;
	public double discount;
	public SeasonDiscount discounts;
	
	public SeasonDiscount(Discount discount){
		discounts = (SeasonDiscount) discount;
	}	
	
	@Override
	public Date getPeriodStart() {
		return discounts.periodstart;
	}

	@Override
	public Date getPeriodEnd() {
		return discounts.periodend;
	}

	@Override
	public void setDiscount(Discount discount) {
		discounts = (SeasonDiscount) discount;
	}

	@Override
	public double getDiscount() {
		return discounts.discount;
	}

}
