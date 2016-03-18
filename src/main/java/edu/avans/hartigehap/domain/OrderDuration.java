/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * @author Olivier Sweep
 *
 */
public abstract class OrderDuration {

	private DateTime startTime;
	private DateTime endTime;
	private DateTime orderDuration;
	private Collection<OrderDuration> orderDurationList = new ArrayList<OrderDuration>();

	public OrderDuration() {

		// Set Default Value
		this.startTime = DateTime.now();
	}

	public DateTime calculateOrderDuration() {

		// TODO: doSomething
		
		return orderDuration;
	}

	public void createList(Collection<OrderDuration> orderDurationList) {
		this.orderDurationList = orderDurationList;
	}

	/**
	 * @return the orderDurationList
	 */
	public Collection<OrderDuration> getList() {
		return orderDurationList;
	}

	/**
	 * @return the startTime
	 */
	public DateTime getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public DateTime getEndTime() {
		return endTime;
	}

	/**
	 * @return the orderDuration
	 */
	public DateTime getOrderDuration() {
		return orderDuration;
	}
	
	abstract void sortList();

}
