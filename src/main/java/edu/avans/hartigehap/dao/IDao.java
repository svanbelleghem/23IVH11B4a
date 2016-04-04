/**
 * 
 */
package edu.avans.hartigehap.dao;

import java.util.List;
import edu.avans.hartigehap.domain.Review;

import javax.sql.DataSource;

/**
 * @author Sander van Belleghem
 *
 *
 * No other way to fill List<Review> with data from database.
 * 
 */
public interface IDao {

	void setDataSource(DataSource ds);
	
	List<Review> selectAll();
}
