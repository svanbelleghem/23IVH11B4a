/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Collection;

/**
 * @author Olivier Sweep
 *
 */
public class SortDescending extends OrderDuration {

	@Override
	void sortList() {

		// Get List
		Collection<OrderDuration> list = getList();

		// Sort List Descending
		Collection<OrderDuration> sorted = (Collection<OrderDuration>) list.stream()
				.sorted((e2, e1) -> e2.getOrderDuration().compareTo(e1.getOrderDuration()));

		// Create list
		createList(sorted);
	}
}
