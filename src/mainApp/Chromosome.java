/* At Milestone 1 - 
 * Class Chromsome creates a Chromosome with a list of bits i.e 0s & 1s
 *Chromsome is also responsible for causing mutation, using a parameter Chance, which guides the mutation 
 */

package mainApp;
import java.util.ArrayList;
import java.util.Random;

public class Chromosome implements Comparable<Chromosome>{

	public ArrayList<Integer> bits;
	private	Random rand = new Random();
	int ones;


	public Chromosome(ArrayList<Integer> chromeBits) {
		// TODO Auto-generated constructor stub
		this.bits = chromeBits;
	}
	
	public Chromosome() {
	}
	
	public int getOnes() {
		return ones;
	}
	
	public int compareTo(Chromosome other) {
		return Integer.compare(ones, other.ones);
	}

	// This method mutates the chromosome i.e flips 0s and 1s depedning on a user input mutation rate Double Chance
	public void mutate(Double chance) {
		for(int i = 0; i < bits.size(); i++) {
			if(rand.ints(0, bits.size()).findFirst().getAsInt() <= chance / bits.size()) {
				if(bits.get(i) == 1) {
					bits.set(i, 0);
				}
				else {
					bits.set(i, 1);
				}
			}
//			System.out.print(bits.get(i));
		}
//		System.out.println("");
	}
	
	//Return the number of bit s i.e 0s and 1s in the Chromosome
	public int getChromeSize() {
//		System.out.println("hello " + bits.size());
		return bits.size();
	}
	
	// THis method is used in the evolutionary loop to create deep copies for the next generations
	public Chromosome copyAndMutate(Double chance) {
		Chromosome copy = new Chromosome(new ArrayList<Integer>());
		for(int i = 0; i < this.bits.size(); i++) {
			copy.bits.add(this.bits.get(i));
		}
		for(int i = 49; i < 50; i++) {
			copy.bits.set(i, copy.bits.get(i - 49));
		}
		copy.mutate(90.0);
//		System.out.println(this.bits);
//		System.out.println(copy.bits);
		return copy;
	}
	
	public int getBasicFit()  {
		int count = 0;
		for(int i: bits) {
			if(i == 1) {
				count++;
			}
		}
//		System.out.println(count);
		return count;
	}
}
