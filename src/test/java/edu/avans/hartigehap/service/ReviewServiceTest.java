/**
 * 
 */
package edu.avans.hartigehap.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.Restaurant;
import edu.avans.hartigehap.domain.Review;
import edu.avans.hartigehap.service.testutil.AbstractTransactionRollbackTest;

/**
 * @author Sander van Belleghem
 *
 */
public class ReviewServiceTest extends AbstractTransactionRollbackTest {

	@Autowired 
	private ReviewService reviewService;
	
	@Test
    public void dummy() {
        // empty - tests configuration of test context.
    }	
}
