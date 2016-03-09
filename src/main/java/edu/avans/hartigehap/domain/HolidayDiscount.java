package edu.avans.hartigehap.domain;

import java.util.Date;

public class HolidayDiscount implements Discount{

	public Date periodstart;
	public Date periodend;
	public double discount;
	public HolidayDiscount discounts;
	
	public HolidayDiscount(Discount discount){
		this.discounts = (HolidayDiscount) discount;
	}
	
	@Override
	public void setDiscount(Discount discount) {
		discounts = (HolidayDiscount) discount;
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
	public double getDiscount() {
		return discounts.discount;
	}

}
