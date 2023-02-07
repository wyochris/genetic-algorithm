/* At Milestone 1 - 
 * Class Chromsome creates a Chromosome with a list of bits i.e 0s & 1s
 *Chromsome is also responsible for causing mutation, using a parameter Chance, which guides the mutation 
 */

package mainApp;
import java.util.ArrayList;
import java.util.Random;

public class Chromosome {

	public ArrayList<Integer> bits;
	private	Random rand = new Random();


	public Chromosome(ArrayList<Integer> chromeBits) {
		// TODO Auto-generated constructor stub
		this.bits = chromeBits;
	}
	
	public Chromosome() {
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
				System.out.print(bits.get(i));
			}
		}
		System.out.println("ee");
	}
	
	public int getChromeSize() {
		System.out.println("hello " + bits.size());
		return bits.size();
	}
	
	public Chromosome copyAndMutate(chance)
	{
		Chromosome copy = new Chromosome();
		for(int i =0;i<=this.bits.size();i++)
		{
			copy.bits.add(this.bits.get(i));
		}
		copy.mutate(chance);
		return copy;
	}
}
