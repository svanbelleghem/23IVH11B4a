/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Collection;
import java.util.List;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewAverageService implements RestaurantReview {

	@Override
	public List<Review> doOperation(Collection<Review> reviews) {
		
		System.out.println("ReviewAverageService called.");
		
		// Sort List by Endtime
		List<Review> sorted = (List<Review>) reviews.stream().sorted((e1, e2) -> e1.getDatetime().compareTo(e2.getDatetime()));
		
		return sorted;
		
	}

}
