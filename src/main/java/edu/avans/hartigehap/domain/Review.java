/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sander van Belleghem
 *
 */

@Entity
@Table(name = "Review")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
public class Review extends DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private ;
	
	@OneToMany
	private Collection<Review> reviews = new ArrayList<>();

	public enum Rating {
		FOODRATING, SERVICERATING
	}

	public Review() {
		
	}

	// represented in database as integer
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "rating")
	private Rating rating;
	
	private int ratingValue;

	@Column(name = "datetime")
	private Date datetime;

	@Column(name = "restaurantId")
	private String restaurantId;
	
	public List<Review> getReviews(RestaurantReview strategy) {
		RestaurantReview strat = strategy;
		System.out.println("GetReviews Called. Containing: " + reviews.size());
		return strat.doOperation(reviews);
	}
}
