/* At Milestone 1 - 
 * FileLoader loads the two example chromosomes. It is also responsible for catching a custom exception 
 * for incorrect file and other IOExceptions 
 *
 */

package mainApp;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class FileLoader {
	Color background = new Color(30,33,36);
	FileLoaderViewer viewer = new FileLoaderViewer(background);
	File file;
	
	public FileLoader() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public ArrayList<Integer> init() {
		// TODO Auto-generated method stub
		this.file = this.viewer.init();
		try {
			return fileToArray(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	public ArrayList<Integer> loadFile() {
//		try {
//			this.file = this.viewer.returnFile();
//			return fileToArray(this.file);
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	
	private ArrayList<Integer> fileToArray(File file) throws FileNotFoundException{
		// TODO make file to array
		// if something is not MAX_SIZE or MIN_SIZE catch
		Scanner s = new Scanner(file);
		String cString = s.nextLine();
		ArrayList<Integer> chromosome = new ArrayList<Integer>();
		String[] cStringArray = cString.split(",");
		for(int i = 0; i < cStringArray.length; i++) {
			chromosome.add(i, Integer.parseInt(cStringArray[i].trim()));
			System.out.print(chromosome.get(i));
		}
		System.out.println("");
		System.out.println("why does this get printed twice");
		s.close();
		return chromosome;
	}
}
