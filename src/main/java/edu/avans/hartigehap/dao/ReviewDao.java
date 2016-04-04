/**
 * 
 */
package edu.avans.hartigehap.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.avans.hartigehap.dao.mapper.ReviewRowMapper;
import edu.avans.hartigehap.domain.Review;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewDao {

	private DataSource dataSource;

	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	public List<Review> selectAll() {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select * from REVIEW", new ReviewRowMapper());
	}
}
