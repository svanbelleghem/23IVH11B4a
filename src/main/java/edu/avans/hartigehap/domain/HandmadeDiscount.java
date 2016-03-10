package edu.avans.hartigehap.domain;

import java.util.Date;

public class HandmadeDiscount implements Discount{

	public Date periodstart;
	public Date periodend;
	public double discount = 1;
	public HandmadeDiscount discounts;
	
	public HandmadeDiscount(Discount discount){
		discounts = (HandmadeDiscount) discount;
	}
	
	@Override
	public Date getPeriodStart() {
		return periodstart;
	}

	@Override
	public Date getPeriodEnd() {
		return periodend;
	}

	@Override
	public void setDiscount(Discount discount) {
		discounts = (HandmadeDiscount) discount;
	}

	@Override
	public double getDiscount() {
		return discount;
	}

	@Override
	public void setPeriodStart(Date date) {
		periodstart = date;		
	}

	@Override
	public void setPeriodEnd(Date date) {
		periodend = date;		
	}

}
