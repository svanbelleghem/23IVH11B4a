package edu.avans.hartigehap.service;

import java.util.Date;

import edu.avans.hartigehap.domain.Discount;
import edu.avans.hartigehap.domain.MenuItem;

public class DiscountItemHandler extends MenuItemHandler {

	public int quantity;
	public Discount discount;
	public boolean hasDiscount;
	public Date currentDate = new Date();
	
	@Override
	public double getPrice(MenuItem item) {
		if(item.discountable == true){
			if(item.hasDiscount == true && discount.getPeriodEnd().before(currentDate) && discount.getPeriodStart().after(currentDate)){
				return item.getPrice() * discount.getDiscount() * quantity;
			}else{
				return item.getPrice() * quantity;
			}
		}else{
			return 0;
		}
	}

}
