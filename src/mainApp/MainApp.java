/* At Milestone 1 - 
 * Acts as the Event Control. All functionality is operated by the MainApp, and implemented through further associated classes.
 *
 */
package mainApp;

import java.util.Random;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	private void runApp() {
		System.out.println("Write your cool arcade game here!");
		Random rand = new Random();
		System.out.println(rand.ints(0, 100).findFirst().getAsInt());
		MainViewer mainV = new MainViewer();
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main
}