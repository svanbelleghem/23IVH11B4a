package edu.avans.hartigehap.domain;

import java.util.Date;

public class HandmadeDiscount implements Discount{

	public Date periodstart;
	public Date periodend;
	public double discount;
	public HandmadeDiscount discounts;
	
	public HandmadeDiscount(Discount discount){
		discounts = (HandmadeDiscount) discount;
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
		discounts = (HandmadeDiscount) discount;
	}

	@Override
	public double getDiscount() {
		return discounts.discount;
	}

}
