package mainApp;

import java.util.ArrayList;

public class PopulationTest
{
	
	public static void testFitFunc(Population tester)

	{
		System.out.println("**FitFun Test**");
		ArrayList<Integer> bits = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++)
		{
			if(Math.random()>0.5)
			{
				bits.add(0);
			}
			else
			{
				bits.add(1);
			}
			
		}
		
		Chromosome a =  new Chromosome(bits);
		System.out.println(tester.fitFunc(a));
		System.out.println();
		
	}
	
	public static void testSmiley(Population tester)
	{
		System.out.println();
		System.out.println("Testing for smiley function");
		System.out.println("First for an random chromosome a (hard coded in this test), should return false unless randomly smiley is generated");
		
		ArrayList<Integer> bits = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++)
		{
			if(Math.random()>0.5)
			{
				bits.add(0);
			}
			else
			{
				bits.add(1);
			}
			
		}
		
		Chromosome a =  new Chromosome(bits);
		
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
		
		for (int number : smileyBits) {
	    System.out.print(number);
		}
		
		System.out.println();
		System.out.println(tester.smileyFitness(a));
		Chromosome smileyTest = new Chromosome(smileyBits);
		System.out.println("Second for an random chromosome simleyBits, should return true ");
		System.out.println(tester.smileyFitness(smileyTest));
		System.out.println();
		System.out.println();
			
	}
	
	public static void testMaxFit(Population tester)
	{
		System.out.println("Testing MaxFit");
		ArrayList<Integer> bits = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++)
		{
			if(Math.random()>0.5)
			{
				bits.add(0);
			}
			else
			{
				bits.add(1);
			}
			
		}
		
		for(int i =0;i<=8;i++)
		{
			bits.set(i,0);
		}
		Chromosome a =  new Chromosome(bits);
		System.out.println("For altered bits of chromosome, should return false since there exist more ones continously than MaxOnes");
		System.out.println(tester.maxFit(a,5));
		for(int i =0;i<100;i++)
		{
			bits.set(i,0);
		}
		Chromosome maxFit = new Chromosome(bits);
		
		System.out.println("Creating a condition where there esxits no ones, this should help understand when MaxFit returns true");
	
		System.out.println(tester.maxFit(maxFit,5));
		System.out.println();
		System.out.println();
		
	}
	
	public static void testEvoLoop(Population tester)
	{
		System.out.println("Testing Evolutionary Loop");
		//Testing Evolutionary Loop
		tester.evoLoop(50, 1,20);
		for(int i =0;i<20;i++)
		{
			Chromosome temp = tester.chromes.get(i);
			for(int j =  0;j<temp.bits.size();j++)
			{
				System.out.print(temp.bits.get(j));
			}
			System.out.println();
		}
		
		System.out.println("Evolutionary Loop succeeds");
		
		System.out.println();
		System.out.println();
	}
	
	public static void testElitism(Population tester)
	{
		System.out.println("Testing Evolutionary Loop with elitism");
		
		tester.elitism(10);
		tester.evoLoop(50, 1,20);
		for(int i =0;i<20;i++)
		{
			Chromosome temp = tester.chromes.get(i);
			for(int j =  0;j<temp.bits.size();j++)
			{
				System.out.print(temp.bits.get(j));
			}
			System.out.println();
		}
		System.out.println("Evolutionary Loop with elitism succeeds");	
	}
	
	public static void testRouletteSelection(Population tester)
	{
		System.out.println(tester.rouletteSelection());	
	}
	
	public static void testBogoSelection(Population tester)
	{
		System.out.println(tester.BogoSelection(20));
	}
	
	public static void testRankSelection(Population tester)
	{
		System.out.println(tester.rankSelection(20));	
	}
	
	public static void main(String[]args)
	{
		Population tester = new Population();
		
		//Testing FitFun
		testFitFunc(tester);
		
		System.out.println();
		System.out.println();
		
		//TestingSmileyFitness
		testSmiley(tester);
		
		System.out.println();
		System.out.println();
		
		//Testing MaxFit
		testMaxFit(tester);
		
		System.out.println();
		System.out.println();
		
		//Testing EvoLoop
		testEvoLoop(tester);
		
		System.out.println();
		System.out.println();
		
		//Testing Elitism
		testElitism(tester);
		
		System.out.println();
		System.out.println();
		
		//Testing Roulette Selection
		testRouletteSelection(tester);
		System.out.println();
		testRouletteSelection(tester);
		System.out.println();
		testRouletteSelection(tester);
		System.out.println();
		testRouletteSelection(tester);
		
		System.out.println();
		System.out.println();
		
		// Testing Bogo Selection
		testBogoSelection(tester);
		System.out.println();
		testBogoSelection(tester);
		System.out.println();
		testBogoSelection(tester);
		System.out.println();
		testBogoSelection(tester);
		
		System.out.println();
		System.out.println();
		
		//Testing Rank Selection
		testRankSelection(tester);
		System.out.println();
		testRankSelection(tester);
		System.out.println();
		testRankSelection(tester);
		System.out.println();
		testRankSelection(tester);
	}
	
}
