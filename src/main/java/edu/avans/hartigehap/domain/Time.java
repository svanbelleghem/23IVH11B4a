/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Sander van Belleghem
 *
 */
public class Time extends Observable {
	
	public Time(){
		
	}
	
	/**
	 * Check if time is passed and if so, notify others
	 */
	public void startInterval(){
	
		/**
		 * Check if time is passed, if so setChanged and notifyObservers
		 */
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * Return current time
	 *
	 */
	public void getCurrentTime(){
		
	}
	
}
