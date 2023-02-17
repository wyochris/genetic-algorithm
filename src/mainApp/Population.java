package mainApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	Generation gen;
	int[] thisGen = new int[100];
	ArrayList<Generation> gens = new ArrayList<Generation>();
	Chromosome[] nextGen;
	double eliteNum = 0;
	boolean isCrossOver = false;
	int alleleSize = 100;
	ArrayList<Chromosome> chromes = new ArrayList<Chromosome>();
	private int popSize;
	private Double chance;
	int[] ones;

	/**
	 * ensures: Make popSize generations of popSize chromosomes, with alleleSize alleles
	 * ensures: thisGen List of Chromosomes creates a new random generation of size 100
	 * 
	 */
	public void generateRandom(int popSize) {
		
		this.popSize = popSize;
		 Random rnd = new Random();
		 rnd.setSeed(0);
		 
//		 this.gen = new Generation(0);

 
		 for(int k = 0; k < popSize; k++)
		 {
			 ArrayList<Integer> bits = new ArrayList<Integer>();
			 this.gen = new Generation(k);

			 for(int j = 0; j < alleleSize; j++ ) 
			 {
				 bits.add(rnd.nextInt(0, 2));
//				 System.out.println(bits.get(j));
			 }
			 Chromosome chrome = new Chromosome(bits);
//			 System.out.println("made a chromosome!");
			 gen.add(chrome);
			 chromes.add(chrome);

		 }
		 
		 gens.add(gen);
//		 printHelp(popSize);
	}
	
//	public void printHelp(int popSize)
//	{
//		for(int i =0;i<popSize;i++)
//		{
//			Chromosome temp = chromes.get(i);
//			for(int j =  0;j<temp.bits.size();j++)
//			{
//				System.out.print(temp.bits.get(j));
//			}
//			System.out.println();
//		}
//		System.out.println();System.out.println();System.out.println();
//	}
	
	public ArrayList<Generation> getGens(){
		return this.gens;
	}
	
	public void nextGen(Double chance){		 

		for(int k = 0; k < popSize; k++) {
			Chromosome newGenChrome = this.gen.getChromes().get(k).copyAndMutate(chance);
			gen.add(newGenChrome);
		}
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
	public void createOne(int pop) {
		for(int i =0;i<pop;i++) 
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
	public void bubbleSort() 
	{
		for(int i=0;i<chromes.size();i++) {
			chromes.get(i).ones = ones[i];
		}
		
		chromes.sort(Comparator.comparingInt(Chromosome::getOnes));
		Collections.reverse(chromes);
		for(int i=0;i<chromes.size();i++) {
			ones[i] = chromes.get(i).ones;
		}
	}
	
	/**
	 * ensures: the top 50 is mutated in passed into the nextGeneration
	 * @param chance, passed in by GUI or default 1
	 */
	public void evoLoopHelper(double chance,int popsize) 
	{
		createOne(popsize);
		bubbleSort();
		//Passing top 50
		for(int i =0;i<popsize/2;i++) {
			chromes.get(i).mutate(chance);
			nextGen[i] = chromes.get(i);
			if(eliteNum>i)
			{
				nextGen[i+popsize/2] = chromes.get(i).copyAndMutate((double) 0);
				
			}
			else
			{
				nextGen[i+popsize/2] = chromes.get(i).copyAndMutate(chance);
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

		chromes.clear();
		for(int i =1;i<=generation;i++) {
			generateRandom(popSize);
			int temp[] = new int[popSize];
			ones = temp;
			nextGen = new Chromosome[chromes.size()];
			evoLoopHelper(chance,popSize);
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
		ArrayList<Integer> smileyBits = new ArrayList<Integer>();
		for(int i =0;i<100;i++)
		{
			smileyBits.add(1);
		}
		smileyBits.set(22, 0);
		smileyBits.set(27, 0);
		smileyBits.set(71, 0);
		smileyBits.set(78, 0);
		
		for(int i = 81;i<=88;i++)
		{
			smileyBits.set(i, 0);
		}
		
		for(int i =0;i<c.getChromeSize();i++)
		{
			if(c.bits.get(i)==smileyBits.get(i))
			{
				
			}
			else
			{
				return false;
			}
		}
		return true;
		
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
			wheel[i] = 100.0*fitFunc(chromes.get(i))/totalOnes;
		}
		
		Random rnd = new Random();
		//rnd.setSeed(0);
		double a = rnd.nextDouble(100);
		for(int c = 0; c<chromes.size();c++)
		{
			if(wheel[c]<=a)
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
	
	public Chromosome rankSelection(int popsize)
	{
		bubbleSort();
		Random rnd = new Random();
		int totalOnes = 0;
		
		for(int i =0;i<chromes.size();i++)
		{
			totalOnes+=fitFunc(chromes.get(i));
		}
		
		double a = rnd.nextInt(popsize);
		
		double[] rankProb = new double[popsize];
		for(int i =0;i<chromes.size();i++)
		{
			 rankProb[i] = 1/totalOnes*(2*a*fitFunc(chromes.get(i)));
		}
		
		for(int c = 0; c<chromes.size();c++)
		{
			if(rankProb[c]<=a)
			{
				a = a-rankProb[c];
			}
			else
			{
				return chromes.get(c);
			}
		}

		return chromes.get(2);
	}
	
	public Chromosome BogoSelection(int popsize)
	{
		Random rnd = new Random();
		int a = rnd.nextInt(popsize);
		return chromes.get(a);
	}
	
	public void elitism(double elitism)
	{
		eliteNum = elitism;
	}
	
}
