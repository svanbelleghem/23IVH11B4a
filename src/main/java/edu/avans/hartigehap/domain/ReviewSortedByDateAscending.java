/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author Sander van Belleghem
 *
 */
public class ReviewSortedByDateAscending implements RestaurantReview, Comparable {

	@Override
	public List<Review> doOperation(Collection<Review> reviews) {

		System.out.println("ReviewSortedByDateAscending called.");
		
		List<Review> list = new ArrayList<Review>(reviews);
				
		Collections.sort(list, new Comparator<Review>() {
			  @Override
			  public int compare(Review o1, Review o2) {
			    return o2.getDatetime().compareTo(o1.getDatetime());
			  }
			});
		
		return list;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
