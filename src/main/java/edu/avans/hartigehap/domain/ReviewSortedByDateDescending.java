/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewSortedByDateDescending implements RestaurantReview {

	@Override
	public List<Review> doOperation(Collection<Review> reviews) {
		
		System.out.println("ReviewSortedByDateDescending called.");
		
		List<Review> list = new ArrayList<Review>(reviews);
		Collections.reverse(list);
		
		return list;
	}

}
