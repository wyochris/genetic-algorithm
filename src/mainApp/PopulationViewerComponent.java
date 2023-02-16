package mainApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import sim.SimulationViewer;

public class PopulationViewerComponent extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//How thick the lines are in the graph
	public static final int LINE_WIDTH   = 2;
	//How high to makes the graph
	public static final int STATS_HEIGHT = 200;
	//How wide to make side panel for reporting numbers
	public static final int SIDE_OFFSET  = 100;
	
	
	private ArrayList<Integer> bestFit = new ArrayList<Integer>();
	private ArrayList<Double> avgFit = new ArrayList<Double>();
	private ArrayList<Integer> worstFit = new ArrayList<Integer>();
	
	private int numGen;
	private int curGenNum;
	private Population pop;
	private Double chance ;
	
	private int bestYP = 1;
	private int worstYP = 1;
	private int avgYP = 1;

	
	//add to the logs
//	public void addEntry(int heathy, int sick, int recovered ) {
//		this.bestFit.add(heathy);
//		this.avgFit.add(sick);
//		this.worstFit.add(recovered);
//	}
	
	//reset the logs
	public void reset() {
		this.bestFit.clear();
		this.avgFit.clear();
		this.worstFit.clear();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		System.out.println("hi im painting");
		
		//Draw box for reporting numbers
		g2.drawRect(0, 0, SIDE_OFFSET-1, this.getHeight() );
		//Fill region for data to be shown
		g2.fillRect(SIDE_OFFSET, 0, this.getWidth()-SIDE_OFFSET, this.getHeight() );
		
		if ( bestFit.size() > 0) {
			g2.setColor(Color.BLACK);
			g2.drawString("Best Fitness:", SIDE_OFFSET/10, STATS_HEIGHT/4 );
			
			g2.setColor(Color.BLUE);
			g2.drawString("Avg Fitness:", SIDE_OFFSET/10, STATS_HEIGHT*2/4);
			
			g2.setColor(Color.RED);
			g2.drawString("Worst Fitness:", SIDE_OFFSET/10, STATS_HEIGHT*3/4 );
			
			System.out.println("hello 1");

					
		}
		
		//Loops through data to make a chart based on the numbers
		for (int i = 0; i < bestFit.size() && i*LINE_WIDTH < this.getWidth(); i++ ) {
			
			//sum to get total to calculate percentage
			double total = bestFit.size();
			
			//make it percentageBased
			int bestPer = (int)(STATS_HEIGHT * bestFit.get(i));
			int avgPer = (int)(STATS_HEIGHT * avgFit.get(i));
			int worstPer = (int)(STATS_HEIGHT * worstFit.get(i));
			
			//offset slightly to get lines to show up

			g2.setColor(Color.BLACK);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, bestYP, SIDE_OFFSET + i*LINE_WIDTH, bestPer + bestYP);
//			System.out.println(SIDE_OFFSET + i*LINE_WIDTH + " " + bestYP + " " + SIDE_OFFSET + i*LINE_WIDTH + " " + bestPer + bestYP);
			
			g2.setColor(Color.BLUE);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, avgYP, SIDE_OFFSET + i*LINE_WIDTH, avgPer + avgYP );
			
			g2.setColor(Color.RED);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, worstYP, SIDE_OFFSET + i*LINE_WIDTH, worstPer + worstYP );
			
			this.bestYP += bestPer;
			this.avgYP += avgPer;
			this.worstYP = worstPer;
			
			System.out.println("hello 2");

		}	
	}
	
	public PopulationViewerComponent() {
		super();
		this.setPreferredSize(new Dimension(800, STATS_HEIGHT) );
	}

	public void start(int numGen, int popSize, double mRate) {
		this.numGen = numGen;
		this.curGenNum = 0;
		this.chance = mRate;
		System.out.println("numGen: " + numGen + " popSize: " + popSize + " mRate: " + mRate);
		Population pop = new Population();
		pop.generateRandom(popSize);
		this.pop = pop;
//		for(Generation t: pop.gens ) {
//			updateGen(t);
//		}
		
	}
	public void updateGen(Generation currentGen) {
		this.bestFit.add(calculateBestFit(currentGen));
		this.avgFit.add(calculateAvgFit(currentGen));
		this.worstFit.add(calculateWorstFit(currentGen));
		if(bestFit.size() > this.numGen) {
			return;
		}
		System.out.println("DONE");
	}

	private Integer calculateWorstFit(Generation cG) {
		// TODO Auto-generated method stub
		return cG.getFitArray().get(0);
	}

	private Integer calculateBestFit(Generation cG) {
		// TODO Auto-generated method stub
		return cG.getFitArray().get(this.numGen - 1);
	}
	
	private Double calculateAvgFit(Generation cG) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < numGen; i++) {
			sum += cG.getFitArray().get(i);
		}
		return (double) (sum / numGen);
	}

	public void update() {
		// TODO Auto-generated method stub
		this.pop.nextGen(this.chance);
		updateGen(this.pop.gens.get(this.curGenNum));
		this.curGenNum++;
	}

	public void clear() {
		// TODO Auto-generated method stub
		this.bestFit.clear();
		this.avgFit.clear();
		this.worstFit.clear();
	}
}
