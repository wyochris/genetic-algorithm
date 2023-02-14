package mainApp;

import java.util.ArrayList;

public class Generation {
	
	private ArrayList<Chromosome> chromes = new ArrayList<Chromosome>();
	private int generation;
	
	public Generation(int genNum){
		this.generation = genNum;
	}
	
	public Generation() {
		// TODO Auto-generated constructor stub
	}

	public void add(Chromosome chrome2) {
		// TODO Auto-generated method stub
		this.chromes.add(chrome2);
	}
}
