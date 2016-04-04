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

	public Collection<OrderItem> orderitems = new ArrayList<OrderItem>();
	public Collection<MenuItem> menuitems = new ArrayList<MenuItem>();
	public double price = 0;
	int quantity = 1;
	
	@Override
	public double getPrice(Collection<Order> order) throws StackOverflowError {	
		Iterator<Order> orderIterator = order.iterator();
		
		while(orderIterator.hasNext()){
			orderitems = orderIterator.next().getOrderItems();
			
			for(OrderItem orderitem : orderitems){
				if(orderitems.size() > 1){
					menuitems.add(orderitem.getMenuItem());
				}else{
					menuitems.add(orderitem.getMenuItem());
					quantity = orderitem.getQuantity();
				}
					
				}
		
			for(MenuItem item : menuitems){
				Date date = new Date();
				if(item.discount != null && item.discount.periodEnd.after(date) && item.discount.periodStart.before(date)){
					price += (item.getPrice() * item.discount.discount) * quantity;
				}else{	
					return 0;
				}
			}
			
			orderIterator.next();
		}
		return price;
	}
	
	public double getPriceNoOrder(){
		return price;
	}

}
