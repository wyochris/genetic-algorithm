package mainApp;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	Color background = new Color(30,33,36);
	FileLoaderViewer viewer;
	String fileName;
	
	public FileLoader() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> loadFile() {
		this.viewer = new FileLoaderViewer(background);
		this.fileName = this.viewer.returnFile();
		return fileToArray(this.fileName);
		
	}

	private ArrayList<Integer> fileToArray(String filename){
		// TODO make file to array
		// if something is not MAX_SIZE or MIN_SIZE catch
		FileReader file = new FileReader(filename);
		Scanner s = new Scanner(file);
		int i = 0;
		ArrayList<Integer> chromosome = new ArrayList<Integer>();
		while(s.hasNextInt()) {
			chromosome.set(i, s.nextInt());
			i++;
		}
		return chromosome;
	}
	
}
