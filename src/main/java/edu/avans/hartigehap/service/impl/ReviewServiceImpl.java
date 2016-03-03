/**
 * 
 */
package edu.avans.hartigehap.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.avans.hartigehap.domain.Review;
import edu.avans.hartigehap.repository.ReviewRepository;
import edu.avans.hartigehap.service.ReviewService;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> findByDate(Date datetime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review save(Review review) {
		// TODO Auto-generated method stub
		return null;
	}

}
