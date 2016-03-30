/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Sander van Belleghem
 *
 */
public class Time extends Observable {

	private int created;
	
	public Time() {
    	created = 0;
	}
	
	public void schedule(){
		Timer timer = new Timer ();
		TimerTask hourlyTask = new TimerTask () {
		    @Override
		    public void run () {
		    	
		    	created = 1;
		    	
		    	setChanged();
				notifyObservers();
		    }
		};

		// Schedule the task to run starting now and then every hour...
		timer.schedule(hourlyTask, 0l, 1000*60*60);
	}
	
	public int isCreated(){
		return created;
	}
}
