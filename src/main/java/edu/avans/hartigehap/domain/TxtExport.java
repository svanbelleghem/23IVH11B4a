/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

/**
 * @author Sander van Belleghem
 *
 */
public class TxtExport extends ReviewReporter {

	@Override
	public void export() {
		super.openFile("txt");
		writeFile();
	}

	@Override
	void writeFile() {
		List<Review> reviews = super.getReviews();

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(super.getFile()));

			for(Review r : reviews){
				writer.println("DateTime: " + r.getDatetime());
				writer.println("\n");
				writer.println("RestaurantId: " + r.getRestaurantId());
				writer.println("\n");
				writer.println("ReviewId: " + r.getId());
				writer.println("\n");
				writer.println("Rating: " + r.getRating());
				writer.println("\n");
				writer.println("\n");
				writer.println("*////////////////////*");
				writer.println("\n");
				writer.println("\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}
}
