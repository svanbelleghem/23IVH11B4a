package edu.avans.hartigehap.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import edu.avans.hartigehap.domain.Discount;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class DiscountItemHandler extends MenuItemHandler {

	public Discount discount;
	public Date currentDate = new Date();
	public OrderItem orderitem = new OrderItem();
	
	@Override
	public double getPrice(Collection<Order> order) {
		if(orderitem.getMenuItem().discountable == true){
			if(orderitem.getMenuItem().hasDiscount == true && discount.getPeriodEnd().before(currentDate) && discount.getPeriodStart().after(currentDate)){
				
				double price = 0;
				Collection<Order> orders = new ArrayList<Order>();
				Iterator<Order> orderIterator = orders.iterator();
				while(orderIterator.hasNext()){
					if(orderitem.getMenuItem().discountable == true)
					price += orderIterator.next().getPrice();
				}
				return price * discount.discount;
				
			}else{
				
				double price = 0;
				Collection<Order> orders = new ArrayList<Order>();
				Iterator<Order> orderIterator = orders.iterator();
				while(orderIterator.hasNext()){
					price += orderIterator.next().getPrice();
				}
				return price;
			}
		}else{
			return 0;
		}
	}

}
