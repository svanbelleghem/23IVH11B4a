package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.MenuItem;

public class RegularHandler extends MenuItemHandler{
	
	public int quantity;
	
	@Override
	public double getPrice(MenuItem item) {
		if(item.discountable == false && item.hasDiscount == false){
			return item.getPrice() * quantity;
		}else{
			super.setSuccessor(m_successor);
			return 0;
		}
	}

}
