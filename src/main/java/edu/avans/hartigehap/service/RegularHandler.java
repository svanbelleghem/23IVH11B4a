package edu.avans.hartigehap.service;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class RegularHandler extends MenuItemHandler{
	
	public Collection<OrderItem> orderitems = new ArrayList<OrderItem>();
	public Collection<MenuItem> menuitems = new ArrayList<MenuItem>();
	public double price = 0;
	int quantity = 1;
	
	@Override
	public double getPrice(Collection<Order> order) throws HeadlessException {
			Iterator<Order> orderIterator = order.iterator();
			
			while(orderIterator.hasNext()){
				orderitems = orderIterator.next().getOrderItems();
				Collection<OrderItem> regularitems = new ArrayList<OrderItem>();
				
				for(OrderItem orderitem : orderitems){
					regularitems.add(orderitem);
					if(orderitem.getMenuItem().discount == null){						
						if(regularitems.size() > 1){
							menuitems.add(orderitem.getMenuItem());
							quantity = 1;
						}else{
							menuitems.add(orderitem.getMenuItem());
							quantity = orderitem.getQuantity();
							
						}
					}else{
						m_successor.getPrice(order);
					}
				}
				
				for(MenuItem item : menuitems){
					if(item.discount == null){
						price += item.getPrice() * quantity;						
					}else{
						m_successor.getPrice(order);
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
