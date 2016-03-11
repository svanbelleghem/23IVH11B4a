package edu.avans.hartigehap.domain;

import java.util.Date;

public interface Discount {	
	public Date getPeriodStart();
	public Date getPeriodEnd();
	public void setDiscount(Discount discount);
	public double getDiscount();
}
