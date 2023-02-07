package mainApp;

/* At Milestone 1 - 

 * Class ChromsomeViewer displays a Chromosome. It is the GUI for a Chromosome i.e it is responsible for creeating a JFrame 
 * and relevant components.
 * 
 * Respresents visually as a grid of colored squares for 1/0 bits green/black for 1/0 respectively
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChromosomeViewer extends JComponent {
	private Color background = new Color (30,33,36);
	private Chromosome chrome;

	public ChromosomeViewer(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated constructor stub
		cViewerDriver(newChrome, frame);
	}

//	public ChromosomeViewer(JFrame frame) {
//		// TODO Auto-generated constructor stub
//		Chromosome newChrome = new Chromosome(chromeBits);
//		cViewerDriver(newChrome, frame);
//	}

	public void cViewerDriver(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated method stub
		this.chrome = newChrome;
	
//		frame.removeAll();
		frame.dispose();
		
		JFrame cViewer = new JFrame();

		final String frameTitle = "Chromosome Viewer";
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		cViewer.setTitle(frameTitle);
//		cViewer.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setSize(800, 600);
		cViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel chromePanel = new JPanel();
		ArrayList<JButton> geneButtons = new ArrayList<JButton>();
		for(int i = 0; i < this.chrome.getChromeSize(); i++) {
			geneButtons.add(new JButton("hi"));
		}
		setButtons(cViewer, geneButtons, chromePanel);
		cViewer.add(chromePanel);
		
		JPanel controlPanel = new JPanel();
		
		JButton mutate = new JButton("Mutate");
		controlPanel.add(mutate);
		
		mutate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newChrome.mutate((double) 10);
				setButtons(cViewer, geneButtons, chromePanel);
				System.out.println("mutated!");
			}
		});
		
		JButton turnLeft = new JButton("Turn Left");
		controlPanel.add(turnLeft);
		
		turnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton turnRight = new JButton("Turn Right");
		controlPanel.add(turnRight);
		
		turnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		cViewer.add(controlPanel, BorderLayout.SOUTH );
		cViewer.pack();
		cViewer.setVisible(true);
	}
	
	public void setButtons(JFrame cViewer, ArrayList<JButton> geneButtons, JPanel chromePanel) {
		for(int i = 0; i < this.chrome.getChromeSize(); i++) {
			geneButtons.set(i, geneButtons.get(i));
			geneButtons.get(i).setText("" + this.chrome.bits.get(i));
			if(this.chrome.bits.get(i) == 1) {
				geneButtons.get(i).setBackground(Color.GREEN);
			}
			else {
				geneButtons.get(i).setBackground(Color.WHITE);
			}
			chromePanel.add(geneButtons.get(i));
		}
	}

}
