package mainApp;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome {
	private ArrayList<Integer> bits;
	private Random rand;

	public Chromosome(ArrayList<Integer> chromeBits) {
		// TODO Auto-generated constructor stub
		this.bits = chromeBits;
	}
	
	public void mutate(Double chance) {
		for(int i = 0; i < bits.size(); i++) {
			if(rand.ints(0, bits.size()).findFirst().getAsInt() <= chance) {
				if(bits.get(i) == 1) {
					bits.set(i, 0);
				}
				else {
					bits.set(i, 1);
				}
			}
		}
	}
	
	public int getChromeSize() {
		return bits.size();
	}

}
