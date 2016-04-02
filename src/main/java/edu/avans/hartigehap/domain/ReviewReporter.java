/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Sander van Belleghem
 *
 */

@Table(name = "Review")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
public class ReviewReporter implements Observer {

	@ManyToMany
	private List<Review> reviews = new ArrayList<Review>();

	private File file;
	Observable observable;

	public ReviewReporter() {

	}

	public void setup(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void update(Observable obs, Object arg) {
		if (obs instanceof Time) {
			Time time = (Time) obs;

			export();
		}
	}

	public void export() {
		openFile(".txt");
		writeFile();
	}

	public void openFile(String fileExtension) {

		System.out.println(fileExtension);

		// Get current datetime
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();

		// Create Filename
		String filename = "export_" + dateFormat.format(date);

		System.out.println(filename);

		// Recieve path to temp folder
		File tempDir = new File(System.getProperty("java.io.tmpdir"));

		try {
			file = File.createTempFile(filename, fileExtension, tempDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeFile() {

		List<Review> reviews = getReviews();

		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(new FileWriter(getFile()));

			for (Review r : reviews) {
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

	public List<Review> getReviews() {
		return reviews;
	}

	public File getFile() {
		return file;
	}
}
