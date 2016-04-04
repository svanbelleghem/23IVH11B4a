/**
 * 
 */
package edu.avans.hartigehap.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import edu.avans.hartigehap.domain.Review;
import edu.avans.hartigehap.repository.ReviewRepository;
import edu.avans.hartigehap.service.ReviewService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sander van Belleghem
 *
 */

@Service("reviewService")
@Repository
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@SuppressWarnings("unused")
	@Autowired 
	private ReviewRepository reviewRepository;

	@Override
	public List<Review> findAll() {
		// MySQL and H2 return the restaurants of findAll() in different order
        // sorting the result makes the behavior less database vendor dependent
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return Lists.newArrayList(reviewRepository.findAll(sort));
	}

	@Override
	@Transactional(readOnly = true)
	public Review findById(Long review) {
        return reviewRepository.findOne(review);
    }

	@Override
	public Review save(Review review) {
		return reviewRepository.save(review);
	}

}
