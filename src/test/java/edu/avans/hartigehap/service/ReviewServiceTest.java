/**
 * 
 */
package edu.avans.hartigehap.service;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.domain.Restaurant;
import edu.avans.hartigehap.domain.Review;
import edu.avans.hartigehap.service.testutil.AbstractTransactionRollbackTest;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewServiceTest extends AbstractTransactionRollbackTest {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
    private RestaurantService restaurantService;
	
	
	@Test
    public void dummy() {
        // empty - tests configuration of test context.
    }	
	
	@Test
    public void createNewReview() {
        Review review = new Review();
        
		DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		Date date = new Date();
		
		List<Restaurant> restaurants = restaurantService.findAll();
		
        review.setDatetime(date);
        review.setRestaurantId(restaurants.get(0).getId());
        review.setRating(review.getRating().FOODRATING);
        review.setRatingValue(5);
        
        reviewService.save(review);
    }	
}
