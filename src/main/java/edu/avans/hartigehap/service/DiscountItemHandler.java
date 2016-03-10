package edu.avans.hartigehap.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import edu.avans.hartigehap.domain.Discount;
import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class DiscountItemHandler extends MenuItemHandler {

	public int quantity;
	public Discount discount;
	public boolean hasDiscount;
	public Date currentDate = new Date();
	public Collection<Order> orders = new ArrayList<Order>();
	public OrderItem orderitem;
	
	@Override
	public double getTotalPrice(Order order) {		
		if(orderitem.getMenuItem().discountable == true){
			if(orderitem.getMenuItem().hasDiscount == true && discount.getPeriodEnd().before(currentDate) && discount.getPeriodStart().after(currentDate)){
				double price = 0;
			    Iterator<Order> orderIterator = orders.iterator();
			    while (orderIterator.hasNext()) {
			        price += orderIterator.next().getPrice();
			    }
				
				return price * orderitem.getMenuItem().discount.getDiscount() * quantity;
				
			}else{
				
				double price = 0;
			    Iterator<Order> orderIterator = orders.iterator(); 
			    
			    while (orderIterator.hasNext()) {
			        price += orderIterator.next().getPrice();
			    }
				
				return price * quantity;
				
			}
		}else{
			
			return 0;
			
		}
	}

}
