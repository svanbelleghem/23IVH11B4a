/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		    	
		    	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
				Date date = new Date();
				
				System.out.println("Running!: " + dateFormat.format(date));
		    	
		    	setChanged();
				notifyObservers();
		    }
		};

		// Schedule the task to run starting now and then every hour...
//		timer.schedule(hourlyTask, 0l, 1000*60*60);
		
		// Schedule the task to run starting now and then every minute...
		timer.schedule(hourlyTask, 0, 60*1000);
	}
	
	public int isCreated(){
		return created;
	}
}
