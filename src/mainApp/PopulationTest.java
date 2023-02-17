package mainApp;

import java.util.ArrayList;

public class PopulationTest
{
	
	public void testFitFun(Population tester)
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
	public void testSmiley(Population tester)
	{
		System.out.println();
		System.out.println("Testing for smiley function");
		System.out.println("First for an random chromosome a, should return false unless randomly smiley is generated");
		
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
	
	public void testEvoLoop(Population tester)
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
	
	public void testElitism(Population tester)
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
	
	
	public static void main(String[]args)
	{

		
//		System.out.println("tests");
//		ArrayList<Integer> bits = new ArrayList<Integer>();
//		for(int i = 1;i<=100;i++)
//		{
//			if(Math.random()>0.5)
//			{
//				bits.add(0);
//			}
//			else
//			{
//				bits.add(1);
//			}
//			
//		}
//		
//		Chromosome a =  new Chromosome(bits);
//		
//		System.out.println();
//		System.out.println("Testing for Fitfunc");
//		System.out.println(tester.fitFunc(a));
//		System.out.println();
//		
		
		
//		ArrayList<Integer> smileyBits = new ArrayList<Integer>();
//		
//		for(int i =0;i<100;i++)
//		{
//			smileyBits.add(1);
//		}
//		smileyBits.set(22, 0);
//		smileyBits.set(27, 0);
//		smileyBits.set(71, 0);
//		smileyBits.set(78, 0);
//		
//		for(int i = 81;i<=88;i++)
//		{
//			smileyBits.set(i, 0);
//		}
//		
//		for (int number : smileyBits) {
//	    System.out.print(number);
//		}
		
		
//		System.out.println();
//		System.out.println("Testing for smiley function");
//		System.out.println("First for an random chromosome a, should return false unless randomly smiley is generated");
//		System.out.println(tester.smileyFitness(a));
//		Chromosome smileyTest = new Chromosome(smileyBits);
//		System.out.println("Second for an random chromosome simleyBits, should return true ");
//		System.out.println(tester.smileyFitness(smileyTest));
//		System.out.println();
//		System.out.println();
//		
		//Testing for maxFit
		
//		for(int i =0;i<=8;i++)
//		{
//			bits.set(i,0);
//		}
//		
//		System.out.println("For altered bits of chromosome, should return false since there exist more ones continously than MaxOnes");
//		System.out.println(tester.maxFit(a,5));
//		for(int i =0;i<100;i++)
//		{
//			bits.set(i,0);
//		}
//		Chromosome maxFit = new Chromosome(bits);
//		
//		System.out.println("Creating a condition where there esxits no ones, this should help understand when MaxFit returns true");
//	
//		System.out.println(tester.maxFit(maxFit,5));
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("Testing Evolutionary Loop");
//		//Testing Evolutionary Loop
//		tester.evoLoop(50, 1,20);
//		for(int i =0;i<20;i++)
//		{
//			Chromosome temp = tester.chromes.get(i);
//			for(int j =  0;j<temp.bits.size();j++)
//			{
//				System.out.print(temp.bits.get(j));
//			}
//			System.out.println();
//		}
//		
//		System.out.println("Evolutionary Loop succeeds");
//		
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("Testing Evolutionary Loop with elitism");
//		
//		tester.elitism(10);
//		tester.evoLoop(50, 1,20);
//		for(int i =0;i<20;i++)
//		{
//			Chromosome temp = tester.chromes.get(i);
//			for(int j =  0;j<temp.bits.size();j++)
//			{
//				System.out.print(temp.bits.get(j));
//			}
//			System.out.println();
//		}
//		System.out.println("Evolutionary Loop with elitism succeeds");
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
		
		
//		//Testing Roulette Selection
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		System.out.println(tester.rouletteSelection());
//		
//		System.out.println();
//		System.out.println();
//		
//		
//		//Testing Bogo Selection
//		System.out.println(tester.BogoSelection(20));
//		System.out.println(tester.BogoSelection(20));
//		System.out.println(tester.BogoSelection(20));
//		System.out.println(tester.BogoSelection(20));
//		System.out.println(tester.BogoSelection(20));
//		
//		System.out.println();
//		System.out.println();
//		
//		//Testing Rank Selection
//		System.out.println(tester.rankSelection(20));
//		System.out.println(tester.rankSelection(20));
//		System.out.println(tester.rankSelection(20));
//		System.out.println(tester.rankSelection(20));
//		System.out.println(tester.rankSelection(20));	
//	}
//}
	}
}
