/**
 * 
 */
package edu.avans.hartigehap.service;

import java.util.Date;
import java.util.List;

import edu.avans.hartigehap.domain.Review;

/**
 * @author Sander van Belleghem
 *
 */
public interface ReviewService {

	List<Review> findAll();

	Review findById(Long id);

	List<Review> findByDate(Date datetime);

	Review save(Review review);
	
}
