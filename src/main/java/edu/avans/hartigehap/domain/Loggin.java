/**
 * 
 */
package edu.avans.hartigehap.domain;

/**
 * @author Sander van Belleghem
 *
 */
public class Loggin {

	// create an object of SingleObject
	private static Loggin instance = new Loggin();

	// make the constructor private so that this class cannot be
	// instantiated
	private Loggin() {
	}

	// Get the only object available
	public static Loggin getInstance() {
		return instance;
	}

	public void openFile() {
		// TODO;
	}

	public void writeFile() {
		// TODO;
	}

	public void saveFile() {
		// TODO;
	}

	public void closeFile() {
		// TODO;
	}
}
