/**
 * 
 */
package edu.avans.hartigehap.service.impl;

import java.util.List;

<<<<<<< HEAD
=======
import org.springframework.transaction.annotation.Transactional;

>>>>>>> 5f36aaff86c8f298f4bc3ae70cc6d4b38042c48b
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import edu.avans.hartigehap.domain.Review;
import edu.avans.hartigehap.repository.ReviewRepository;
import edu.avans.hartigehap.service.ReviewService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sander van Belleghem
 *
 */

@Repository
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired 
	private ReviewRepository reviewRepository;

	public List<Review> findAll() {
		// MySQL and H2 return the reviews of findAll() in different order
        // sorting the result makes the behavior less database vendor dependent
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return Lists.newArrayList(reviewRepository.findAll(sort));
	}

	@Transactional(readOnly = true)
	public Review findById(String review) {
        return reviewRepository.findOne(review);
    }

	public Review save(Review review) {
		return reviewRepository.save(review);
	}

}
