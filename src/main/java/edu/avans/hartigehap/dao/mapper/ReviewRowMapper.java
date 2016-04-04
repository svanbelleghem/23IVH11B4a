/**
 * 
 */
package edu.avans.hartigehap.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewRowMapper implements RowMapper {

	  @Override
	  public Object mapRow(ResultSet rs, int line) throws SQLException {
	    ReviewResultSetExtractor extractor = new ReviewResultSetExtractor();
	    return extractor.extractData(rs);
	  }

}
