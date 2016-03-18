package edu.avans.hartigehap.service;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class RegularHandler extends MenuItemHandler{
	
	public OrderItem orderitem;
	
	@Override
	public double getPrice(Collection<Order> order) throws HeadlessException {
		//if(orderitem.getMenuItem().discountable == false && orderitem.getMenuItem().hasDiscount == false){
			double price = 0;
			order = new ArrayList<Order>();			
			Iterator<Order> orderIterator = order.iterator();
			while(orderIterator.hasNext()){
				price += orderIterator.next().getPrice();
				JOptionPane.showMessageDialog(null, orderIterator.next().getPrice());
			}
			return price;
		//}else{
//			super.setSuccessor(m_successor);
//			return 0;
		//}
	}

}
