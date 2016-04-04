package edu.avans.hartigehap.service;

import java.util.ArrayList;
import java.util.Collection;

import com.sun.jna.Library.Handler;

import edu.avans.hartigehap.domain.Order;

public abstract class MenuItemHandler {

	
	protected MenuItemHandler m_successor;
	
	public void setSuccessor(MenuItemHandler successor){
		m_successor = successor;
		
	}
	
	public abstract double getPrice(Collection<Order> order);
	
	public abstract double getPriceNoOrder();
}
