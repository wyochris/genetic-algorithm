package mainApp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Purpose: Population class is intended to hold the entire population of chromosomes, and
 * 			hold instances of generations for organizational purposes. 
 * Functions: Population also sorts populations according to fitness, and generates new 
 * 			  generations
 *  
 * @author khattam & 
 * 
 *
 */
public class Population {
	Generation gen;
	int[] thisGen = new int[100];
	ArrayList<Generation> gens = new ArrayList<Generation>();
	Chromosome[] nextGen;
	double eliteNum = 0;
	boolean isCrossOver = false;
	int alleleSize = 100;
	private ArrayList<Chromosome> chromes = new ArrayList<Chromosome>();
<<<<<<< HEAD
	private int popSize;
	private Double chance;
=======
	int[] ones = new int[chromes.size()];
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2022-23-final-project-w23_r_201

	/**
<<<<<<< HEAD
	 * ensures: Make popSize generations of popSize chromosomes, with alleleSize alleles
=======
	 * ensures: thisGen List of Chromosomes creates a new random generation of size 100
>>>>>>> branch 'master' of https://github.com/rhit-csse220/csse220-winter-2022-23-final-project-w23_r_201
	 * 
	 */
	public void generateRandom(int popSize) {
		
		this.popSize = popSize;
		
		 Random rnd = new Random();
		 rnd.setSeed(0);
		 
		 this.gen = new Generation(0);

 
		 for(int k = 0; k < popSize; k++) {
			 ArrayList<Integer> bits = new ArrayList<Integer>();

			 for(int j = 0; j < alleleSize; j++ ) {
				 bits.add(rnd.nextInt(0, 2));
//				 System.out.println(bits.get(j));
			 }
			 Chromosome chrome = new Chromosome(bits);
//			 System.out.println("made a chromosome!");
			 gen.add(chrome);
		 }
		 
		 gens.add(gen);
	}
	
	public ArrayList<Generation> getGens(){
		return this.gens;
	}
	
	public void nextGen(Double chance){		 

		for(int k = 0; k < popSize; k++) {
			Chromosome newGenChrome = this.gen.getChromes().get(k).copyAndMutate(chance);
			gen.add(newGenChrome);
		}
		System.out.println("made a gen!");

		gens.add(gen);
	}
	/**
	 * 
	 * @return fitarray of a generation
	 */
//	public ArrayList<Integer> getFitArray(Generation gen){
//		ArrayList<Integer> fitArray = new ArrayList<Integer>();
//		for(int i = 0; i < 100; i++) {
//			fitArray.add(gen.getChromes().get(i).getBasicFit());
//			System.out.println(fitArray.get(i));
//		}
//		return fitArray;
//	}
		
//	/**
//	 * ensures: the number of 1's in a chromosome's alleles is counted
//	 * @param Chromosome c to be evaluated
//	 * @return count, the number of 1's
//	 * 
//	 */
	public int fitFunc(Chromosome c)
	{
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
		for(int i =0;i<thisGen.length;i++) 
		{
			ones[i] = fitFunc(chromes.get(i));
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
					
					temp=chromes.get(i);
					chromes.remove(i);
					chromes.add(i,chromes.get(i+1));
					chromes.remove(i+1);
					chromes.add(i+1,temp);
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
			chromes.get(i).mutate(chance);
			nextGen[i] = chromes.get(i);
			if(eliteNum!=0)
			{
				nextGen[i+50] = chromes.get(i).copyAndMutate((double) 0);
				eliteNum--;
			}
			else
			{
				nextGen[i+50] = chromes.get(i).copyAndMutate(chance);
			}
		}
	}
	
	/**
	 * ensures: a new generation of 100 chromosomes is created and generated randomly
	 * 			and then sorted and mutated
	 * @param chance
	 * @param generation
	 */
	public void evoLoop(double chance, int generation,int popSize) {
		
		for(int i =1;i<=generation;i++) {
			generateRandom(popSize, i);
			nextGen = new Chromosome[chromes.size()];
			evoLoopHelper(chance);
			for(int j =0;i<chromes.size();i++)
			{
				Chromosome buffer = nextGen[i];
				chromes.set(i, buffer);
			}
		}
	}
	//This is another type of fitness function 
	public boolean smileyFitness(Chromosome c)
	{
		int a[]= new int[12];
		a[0] = 22;
		a[1] = 27;
		a[2] = 71;
		a[3] = 78;
		int k = 4;
		for(int i =81;i<=88;i++)
		{
			a[k] = i;
			k++;
		}
		
		//At this we have created the smiley indexes i.e all points where there should be 0s in the smiley
		
		for(int i =0;i<c.bits.size();i++) {
			
			if(c.bits.get(i)==0 && isIn(i,a))
			{
				
			}
			else
			{
				return false;
			}
		}
		return true;	
	}
	
	public boolean isIn(int i, int[] a)
	{
		for(int j = 0;j<a.length;j++)
		{
			if(a[j]==i)
			{
				return true;
			}
		}
		return false;
	}
	
	//This function checks if the chromosome has more continous 1s than allowed param maxOnes. If it does then it is decrlared unfit
	public boolean maxFit(Chromosome c, int maxOnes)
	{
		int maxCount = 0;
		for(int i =0;i<c.bits.size();i++) 
		{
			if(c.bits.get(i)==1)
				maxCount++;
			if(maxCount>maxOnes)
			{
				return false;
			}
		}
		return true ;
	}
	
	/*his function stochastically selects some chromosomes. Think of it has a random wheel spin however
	all parts on this wheel is not equal. THe highers 1s a chromosome has, 
	the higher chunk it has in the wheel
	vice versa 
	  */
	/**
	 * ensures: stochastic wheel selection for chromosomes (i thought it would save time if i write this java docs (driver Medhansh)
	 * 			spins a wheel, with each chromosome having unequal chunks of the wheel based on their fitness
	 * @param chance
	 * @param generation
	 */
	public Chromosome rouletteSelection()
	{
		int totalOnes = 0;
		
		for(int i =0;i<chromes.size();i++)
		{
			totalOnes+=fitFunc(chromes.get(i));
		}
		
		//Create our wheel
		//This is an array with  each 
		//Each wheel entry corresponds to the  % [ratio] of this chromosomes 1s to total ones
		double[] wheel = new double[chromes.size()];
		for(int i =0;i<chromes.size();i++)
		{
			wheel[i] = 100*fitFunc(chromes.get(i))/totalOnes;
		}
		
		Random rnd = new Random();
		rnd.setSeed(0);
		double a = rnd.nextDouble(100);

		
		for(int c = 0; c<chromes.size();c++)
		{
			if(wheel[c]>=a)
			{
				a = a-wheel[c];
			}
			else
			{
				return chromes.get(c);
			}
		}
		return chromes.get(0);
	}
	
	public void elitism(double elitism)
	{
		eliteNum = elitism;
	}
	
}
