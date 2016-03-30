/**
 * 
 */
package edu.avans.hartigehap.domain;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
public abstract class ReviewReporter {

	@ManyToMany
	private List<Review> reviews = new ArrayList<Review>();
	
	private File file;
	
	abstract void export();

	public void openFile(String fileExtension) {
		
		// Get current datetime
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();
		
		// Create Filename
		String filename = "export_" + dateFormat.format(date) + fileExtension;
		
		// Recieve path to temp folder
		File tempDir = new File(System.getProperty("java.io.tmpdir"));
		
		try {
			file = File.createTempFile(filename, fileExtension, tempDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	abstract void writeFile();
	
	public List<Review> getReviews(){
		return reviews;
	}
	
	public File getFile(){
		return file;
	}
}
