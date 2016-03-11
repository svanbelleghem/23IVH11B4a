package edu.avans.hartigehap.service;

import com.sun.jna.Library.Handler;

import edu.avans.hartigehap.domain.MenuItem;

public abstract class MenuItemHandler {

	protected Handler m_successor;
	public int quantity = 0;
	
	public void setSuccessor(Handler successor){
		m_successor = successor;
		
	}
	
	public abstract double getPrice(MenuItem item);
	
}
