package mainApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JComponent;

//import sim.SimulationViewer;

public class PopulationViewerComponent extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//How thick the lines are in the graph
	public static final int LINE_WIDTH   = 10;
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
	
	private int bestYP = this.getHeight();
	private int worstYP = this.getHeight();
	private int avgYP = this.getHeight();
	private String selectionType;

	
	
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
		
		g2.drawRect(0, 0, SIDE_OFFSET-1, this.getHeight() );
		g2.fillRect(SIDE_OFFSET, 0, this.getWidth()-SIDE_OFFSET, this.getHeight() );
		
		if ( bestFit.size() > 0) {
			g2.setColor(Color.BLACK);
			g2.drawString("Best Fitness:", SIDE_OFFSET/10, this.getHeight() * 8 * bestFit.get(bestFit.size() - 1) / this.getHeight() );
			
			g2.setColor(Color.BLUE);
			g2.drawString("Avg Fitness:", SIDE_OFFSET/10, (int) (this.getHeight() * 5 * avgFit.get(avgFit.size() - 1) / this.getHeight()));
			
			g2.setColor(Color.RED);
			g2.drawString("Worst Fitness:", SIDE_OFFSET/10, this.getHeight() * 3 * worstFit.get(worstFit.size() - 1) / this.getHeight() );
			
			System.out.println("hello 1");
			
			this.bestYP = this.getHeight() * 8 * bestFit.get(bestFit.size() - 1) / this.getHeight();
			this.avgYP = (int) (this.getHeight() * 5 * avgFit.get(bestFit.size() - 1) / this.getHeight());
			this.worstYP = this.getHeight() * 3 * worstFit.get(bestFit.size() - 1) / this.getHeight();


					
		}
		
		//Loops through data to make a chart based on the numbers
		for (int i = 0; i < bestFit.size() && i*LINE_WIDTH < this.getWidth(); i++ ) {
			
			//sum to get total to calculate percentage
			double total = bestFit.size();
			
			//make it percentageBased
			int bestPer = (int)(this.getHeight() * 8 * bestFit.get(bestFit.size() - 1) / this.getHeight());
			int avgPer = (int)(this.getHeight() * 5 * avgFit.get(bestFit.size() - 1)) / this.getHeight();
			int worstPer = (int)(this.getHeight() * 3 * worstFit.get(bestFit.size() - 1)) / this.getHeight();
			
			//offset slightly to get lines to show up

			g2.setColor(Color.BLACK);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, this.bestYP,
					SIDE_OFFSET + i*LINE_WIDTH + LINE_WIDTH, bestPer);



			
			g2.setColor(Color.BLUE);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, this.avgYP,
					SIDE_OFFSET + i*LINE_WIDTH + LINE_WIDTH, avgPer);	
			
			g2.setColor(Color.RED);
			g2.drawLine(SIDE_OFFSET + i*LINE_WIDTH, this.worstYP,
					SIDE_OFFSET + i*LINE_WIDTH + LINE_WIDTH, worstPer);
			
			this.bestYP = bestPer;
			this.avgYP = avgPer;
			this.worstYP = worstPer;
			
//			System.out.println("hello 2");

		}	
	}
	
	public PopulationViewerComponent() {
		super();
		this.setPreferredSize(new Dimension(800, STATS_HEIGHT) );
	}

	public void start(int numGen, int popSize, double mRate, String selection, Boolean isElitism) {
		System.out.println(isElitism);
		this.selectionType = selection;
		this.numGen = numGen;
		this.curGenNum = 0;
		this.chance = mRate;
		System.out.println("numGen: " + numGen + " popSize: " + popSize + " mRate: " + mRate);
		Population pop = new Population();
		pop.generateRandom(popSize);
		this.pop = pop;

		
	}
	public void updateGen(Generation currentGen) {
		this.bestFit.add(calculateBestFit(currentGen));
		this.avgFit.add((double) calculateAvgFit(currentGen));
		this.worstFit.add(calculateWorstFit(currentGen));
		if(bestFit.size() > this.numGen) {
			return;
		}
		System.out.println("DONE");
	}

	private Integer calculateWorstFit(Generation cG) {
		// TODO Auto-generated method stub
		return cG.getFitArray().get(cG.getFitArray().size() - 1);

	}

	private Integer calculateBestFit(Generation cG) {
		// TODO Auto-generated method stub
		return cG.getFitArray().get(0);

	}
	
	private int calculateAvgFit(Generation cG) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < cG.getFitArray().size(); i++) {
			sum += cG.getFitArray().get(i);
		}
		System.out.println(sum / cG.getFitArray().size());

		return (int) (sum / cG.getFitArray().size());
	}

	public void update() {
		System.out.println("updating");
		this.pop.nextGen(this.chance);
		updateGen(this.pop.gens.get(pop.gens.size() - 1));
	}

	public void clear() {
		this.bestFit.clear();
		this.avgFit.clear();
		this.worstFit.clear();
	}
}
