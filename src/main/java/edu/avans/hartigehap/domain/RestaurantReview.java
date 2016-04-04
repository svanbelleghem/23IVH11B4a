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
public interface RestaurantReview {
		
	public List<Review> doOperation(Collection<Review> reviews);
}
