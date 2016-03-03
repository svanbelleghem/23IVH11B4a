/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Sander van Belleghem
 *
 */
public abstract class ReviewReporter {
	
	private Collection<Review> reviews = new ArrayList<Review>();
	
	
	abstract void export();
}
