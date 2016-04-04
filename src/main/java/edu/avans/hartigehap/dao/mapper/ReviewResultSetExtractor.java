/**
 * 
 */
package edu.avans.hartigehap.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewResultSetExtractor implements ResultSetExtractor {

	  @Override
	  public Object extractData(ResultSet rs) throws SQLException {
	    
		  while (rs.next()) {
	            String rating = rs.getString("RATING");
	            String datetime = rs.getString("DATETIME");
	            String rating_val = rs.getString("RATING_VALUE");
	            
	            System.out.println(rating + "\t" + rating_val + "\t" + datetime);
	        }
		  
	    return null;
	  }
	
}
