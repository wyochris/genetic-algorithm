package mainApp;

import java.util.ArrayList;
import java.util.Random;

public class Population
{
	Chromosome[] thisGen = new Chromosome[100];
	int[] ones = new int[100];
	Chromosome[] nextGen = new Chromosome[100];
	
	Random rnd = new Random();
	rnd.setSeed(seed);
	
	public int fitFunc(Chromosome c)
	{
	
		int count = 0;
		for(int i =0;i<c.bits.size();i++)
		{
			if(c.bits.get(i)==1)
				count++;
		}
		return count;
	}
	
	public void createOne()
	{
		for(int i =0;i<thisGen.length;i++)
		{
			ones[i] = fitFunc(thisGen[i]);
		}
	}
	
	public void bubbleSort()
	{
		Chromosome temp;
		int tempInt;
		boolean isSorted=false;
		while(!isSorted)
		{
			isSorted=true;
			for(int i =0;i<ones.length-1;i++)
			{
				if(ones[i]>ones[i+1])
				{
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
	
	public void evoLoopHelper()
	{
		createOne();
		bubbleSort();
		//Passing top 50
		for(int i =0;i<50;i++)
		{
			nextGen[i] = thisGen[i];
			Chromosome temp = new Chromosome();
			temp=thisGen[i];
			temp.mutate(chance); //As Dr. Yoder what should chance be
			nextGen[i+50] = temp;
		}
	}
	
	public void evoLoop(int generation)
	{
		for(int i =1;i<=generation,i++)
		{
			evoLoopHelper();
			
		}
		
		
	}
}
