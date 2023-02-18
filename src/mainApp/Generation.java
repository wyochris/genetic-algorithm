package mainApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Generation {
	
	private ArrayList<Chromosome> chromes = new ArrayList<Chromosome>();
	private int generation;
	
	public Generation(int genNum){
		this.generation = genNum;
	}
	
	public Generation() {
	}

	public void add(Chromosome c) {
		this.chromes.add(c);
	}

	/**
	 * @return the chromes
	 */
	public ArrayList<Chromosome> getChromes() {
		return chromes;
	}

	/**
	 * @return the generation
	 */
	public int getGeneration() {
		return generation;
	}
	
	public ArrayList<Integer> getFitArray(){
		ArrayList<Integer> fitArray = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			fitArray.add(chromes.get(i).getBasicFit());
		}
		Collections.sort(fitArray);
		return fitArray;
	}
	
}
