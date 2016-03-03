/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import edu.avans.hartigehap.domain.Bill.BillStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
	
    public enum Rating {
        FOODRATING, SERVICERATING
    }

	public Review(Restaurant res) {
		// Convert String to Long
		restaurantId = Long.parseLong(res.getId());
	}
    
    // represented in database as integer
    @Enumerated(EnumType.ORDINAL)
    private Rating rating;
	
	@Column(name = "datetime")
	private Date datetime;
	
	@Column(name = "restaurantId")
	private Long restaurantId;
}
