/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author Sander van Belleghem
 *
 */
public class TxtExport extends ReviewReporter {

	public void export() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();
		
		System.out.println("Export running!: " + dateFormat.format(date));
		
		
		// super.openFile("txt");
		writeFile();
	}

	@Override
	public void writeFile() {

		// Get current datetime
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();
		
		System.out.println("Running!: " + dateFormat.format(date));
    	
		// List<Review> reviews = super.getReviews();
		//
		// PrintWriter writer = null;
		// try {
		// writer = new PrintWriter(new FileWriter(super.getFile()));
		//
		// for(Review r : reviews){
		// writer.println("DateTime: " + r.getDatetime());
		// writer.println("\n");
		// writer.println("RestaurantId: " + r.getRestaurantId());
		// writer.println("\n");
		// writer.println("ReviewId: " + r.getId());
		// writer.println("\n");
		// writer.println("Rating: " + r.getRating());
		// writer.println("\n");
		// writer.println("\n");
		// writer.println("*////////////////////*");
		// writer.println("\n");
		// writer.println("\n");
		// }
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// if (writer != null)
		// writer.close();
		// }
	}
}
