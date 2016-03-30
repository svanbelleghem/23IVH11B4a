/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Collection;

/**
 * @author Olivier Sweep
 *
 */
public class SortByDate extends OrderDuration {

	@Override
	void sortList() {

		// Get List
		Collection<OrderDuration> list = getList();

		// Sort List by Endtime
		Collection<OrderDuration> sorted = (Collection<OrderDuration>) list.stream().sorted((e1, e2) -> e1.getEndTime().compareTo(e2.getEndTime()));

		// Create list
		createList(sorted);
	}
}
