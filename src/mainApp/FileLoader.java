package mainApp;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	public static final int MAX_SIZE = 100;
	public static final int MIN_SIZE = 20;
	
	String loadFile () throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		String filename = null;
		while(true) {
			System.out.println("What file should I load? ");
			filename = s.nextLine();
			fileToArray(filename);
			break;
		}
		return filename;
	}

	private void fileToArray(String filename) {
		// TODO make file to array
		// if something is not MAX_SIZE or MIN_SIZE
		Scanner s = new Scanner(filename);
		int lineCount = 0;
		int bitCount = 0;
		ArrayList<ArrayList<Integer>> chromosome = new ArrayList<ArrayList<Integer>>();
		while(s.hasNextLine()) {
			ArrayList<Integer> line = new ArrayList<Integer>();
			while(bitCount < 10) {
				line.set(lineCount, s.nextInt());
				bitCount++;
			}
			chromosome.add(line);
			bitCount = 0;
			lineCount++;
		}
	}
	
	
	
	
}
