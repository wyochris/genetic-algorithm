package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class PopulationViewerComponent extends JComponent {
	
	//How thick the lines are in the graph
	public static final int LINE_WIDTH   = 2;
	//How high to makes the graph
	public static final int STATS_HEIGHT = 200;
	//How wide to make side panel for reporting numbers
	public static final int SIDE_OFFSET  = 100;
	
	
	private ArrayList<Integer> bestFit = new ArrayList<Integer>();
	private ArrayList<Integer> avgFit = new ArrayList<Integer>();
	private ArrayList<Integer> worstFit = new ArrayList<Integer>();
	
	//add to the logs
	public void addEntry(int heathy, int sick, int recovered ) {
		this.bestFit.add(heathy);
		this.avgFit.add(sick);
		this.worstFit.add(recovered);
	}
	
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
		
		//Draw box for reporting numbers
		g2.drawRect(0, 0, SIDE_OFFSET-1, this.getHeight() );
		//Fill region for data to be shown
		g2.fillRect(SIDE_OFFSET, 0, this.getWidth()-SIDE_OFFSET, this.getHeight() );
		
		//Don't try to draw unless there is data to be drawn
		if ( bestFit.size() > 0) {
			//Use color constants so that they line up with the color of the Person categories.
			g2.setColor(Color.GREEN);
			g2.drawString("Best Fitness:" + bestFit.get(bestFit.size()-1 ), SIDE_OFFSET/10, STATS_HEIGHT/4 );
			
			g2.setColor(Color.BLUE);
			g2.drawString("Average Fitness:" + avgFit.get(avgFit.size()-1 ), SIDE_OFFSET/10, STATS_HEIGHT*2/4);
			
			g2.setColor(Color.RED);
			g2.drawString("Worst Fitness:" + worstFit.get(worstFit.size()-1 ), SIDE_OFFSET/10, STATS_HEIGHT*3/4 );
		}
		
		//Loops through data to make a chart based on the numbers
		for (int i=0; i< bestFit.size() && i*LINE_WIDTH < this.getWidth() ; i++ ) {
			
			//sum to get total to calculate percentage
			double total = bestFit.size();
			
			//make it percentageBased
			int bestPer = (int)(STATS_HEIGHT * bestFit.get(i) / total);
			int avgPer = (int)(STATS_HEIGHT * avgFit.get(i) / total);
			int worstPer = (int)(STATS_HEIGHT * worstFit.get(i) / total);
			
			//offset slightly to get lines to show up
			int yPos = 1;
			
			//we use the defined colors from Person class
			//Draw from the top down
			g2.setColor(Color.GREEN);
			g2.fillRect(SIDE_OFFSET + i*LINE_WIDTH, yPos, LINE_WIDTH, yPos + bestPer );
			yPos += bestPer;
			
			g2.setColor(Color.BLUE);
			g2.fillRect(SIDE_OFFSET + i*LINE_WIDTH, yPos, LINE_WIDTH, yPos + avgPer );
			yPos += avgPer;
			
			g2.setColor(Color.RED);
			g2.fillRect(SIDE_OFFSET + i*LINE_WIDTH, yPos, LINE_WIDTH, yPos + worstPer );
		}	
	}
}
