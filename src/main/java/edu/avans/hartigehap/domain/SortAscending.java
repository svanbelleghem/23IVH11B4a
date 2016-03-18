/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Collection;

/**
 * @author Olivier Sweep
 *
 */
public class SortAscending extends OrderDuration {
	
	@Override
	void sortList() {

		// Get List
		Collection<OrderDuration> list = getList();

		// Sort List Ascending
		Collection<OrderDuration> sorted = (Collection<OrderDuration>) list.stream()
				.sorted((e1, e2) -> e1.getOrderDuration().compareTo(e2.getOrderDuration()));

		// Create list
		createList(sorted);
	}
}
