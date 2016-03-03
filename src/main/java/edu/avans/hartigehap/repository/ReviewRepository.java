/**
 * 
 */
package edu.avans.hartigehap.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.avans.hartigehap.domain.Review;


/**
 * @author Sander van Belleghem
 *
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

}
