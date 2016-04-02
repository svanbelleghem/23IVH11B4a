/**
 * 
 */
package edu.avans.hartigehap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.avans.hartigehap.domain.Review;


/**
 * @author Sander van Belleghem
 *
 */

@Service("reviewService")
@Repository
@Transactional
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

}
