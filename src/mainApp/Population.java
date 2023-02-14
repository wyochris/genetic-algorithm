package mainApp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Purpose: Population class is intended to hold the entire population of chromosomes, and
 * 			hold instances of generations for organizational purposes. 
 * Functions: Population also sorts populations according to fitness, and generates new 
 * 			  generations
 *  
 * @author lardnece
 *
 */
public class Population {
	ArrayList<Chromosome> thisGen = new ArrayList<Chromosome>();
	int[] ones = new int[100];
	Chromosome[] nextGen;
	double eliteNum = 0;

	/**
	 * ensures: thisGen Lis t of Chromosomes creates a new random generation of size 100
	 * 
	 */
	public void generateRandom() {
		
		 Random rnd = new Random();
		 rnd.setSeed(0);
		 
		 for(int j =0;j<100;j++) {
			 ArrayList<Integer> arr = new ArrayList<Integer>();		 
			for(int i =0;i<100;i++) {
				if(rnd.nextBoolean())
					arr.add(1);
				else
					arr.add(0);
			}
			Chromosome a = new Chromosome(arr);
			thisGen[j]=a;
		 } 
	}
	
	/**
	 * ensures: the number of 1's in a chromosome's alleles is counted
	 * @param Chromosome c to be evaluated
	 * @return count, the number of 1's
	 * 
	 */
	public int fitFunc(Chromosome c) {
	
		int count = 0;
		for(int i =0;i<c.bits.size();i++) {
			if(c.bits.get(i)==1)
				count++;
		}
		return count;
	}
	
	/**
	 * ensures: (not sure) this function ensures that a separate list called ones 
	 * 			holds the fitness count of the chromosomes
	 * 
	 */
	public void createOne() {
		for(int i =0;i<thisGen.length;i++) {
			ones[i] = fitFunc(thisGen[i]);
		}
	}
	
	/**
	 * ensures: The chromosomes are sorted based on the number of 1s bits
	 * 
	 * Checks for 1 bits and swaps the respective chromosome.
	 * 		- Chris (Reviewer)
	 */
	public void bubbleSort() {
		Chromosome temp;
		int tempInt;
		boolean isSorted=false;
		while(!isSorted) {
			isSorted=true;
			for(int i =0;i<ones.length-1;i++) {
				if(ones[i]>ones[i+1]) {
					tempInt = ones[i];
					ones[i]=ones[i+1];
					ones[i+1]=tempInt;
					
					temp=thisGen[i];
					thisGen[i] = thisGen[i+1];
					thisGen[i+1] = temp;
					isSorted=false;	
				}
			}
			
		}
	}
	
	/**
	 * ensures: the top 50 is mutated in passed into the nextGeneration
	 * @param chance, passed in by GUI or default 1
	 */
	public void evoLoopHelper(double chance) {
		createOne();
		bubbleSort();
		//Passing top 50
		for(int i =0;i<50;i++) {
			thisGen[i].mutate(chance);
			nextGen[i] = thisGen[i];
			if(eliteNum!=0)
			{
				nextGen[i+50] = thisGen[i].copyAndMutate(0);
				eliteNum--;
			}
			else
			{
				nextGen[i+50] = thisGen[i].copyAndMutate(chance);
			}
		}
	}
	
	/**
	 * ensures: a new generation of 100 chromosomes is created and generated randomly
	 * 			and then sorted and mutated
	 * @param chance
	 * @param generation
	 */
	public void evoLoop(double chance, int generation) {
		generateRandom();
		for(int i =1;i<=generation;i++) {
			nextGen = new Chromosome[100];
			evoLoopHelper(chance);
			for(int j =0;i<100;i++){
				thisGen[j]=nextGen[j];
			}
		}
	}
	
	public void elitism(double elitism)
	{
		eliteNum = elitism;
	}
	
}
