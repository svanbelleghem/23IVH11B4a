package edu.avans.hartigehap.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class RegularHandler extends MenuItemHandler{
	
	public int quantity;
	public Collection<Order> orders = new ArrayList<Order>();
	public OrderItem orderitem;
	
	@Override
	public double getTotalPrice(Order order) {
		if(orderitem.getMenuItem().discountable == false || orderitem.getMenuItem().discountable == true && orderitem.getMenuItem().hasDiscount == false){			
			double price = 0;
		    Iterator<Order> orderIterator = orders.iterator(); 
		    
		    while (orderIterator.hasNext()) {
		        price += orderIterator.next().getPrice();
		    }
		    return price;
			
		}else{
			super.setSuccessor(m_successor);
			return 0;
		}
	}

}
