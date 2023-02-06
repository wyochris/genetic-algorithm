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

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChromosomeViewer extends JComponent {
	private Color background = new Color (30,33,36);

	public ChromosomeViewer(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated constructor stub
		cViewerDriver(newChrome, frame);
	}

	public ChromosomeViewer(JFrame frame) {
		// TODO Auto-generated constructor stub
	}

	public void cViewerDriver(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated method stub
		
		frame.removeAll();
		frame.dispose();
		
		JFrame cViewer = new JFrame();
		
		final String frameTitle = "Chromosome Viewer";
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		cViewer.setTitle(frameTitle);
//		cViewer.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setSize(400, 400);
		cViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cViewer.getContentPane().setBackground(this.background);	
		
		JPanel controlPanel = new JPanel();
		
		JButton mutate = new JButton("Mutate");
		controlPanel.add(mutate);
		
		mutate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newChrome.mutate((double) 10);
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
		
		JPanel chromePanel = new JPanel();
		
		for(int i = 0; i < newChrome.getChromeSize(); i++) {
			JButton gene = new JButton();
			chromePanel.add(gene);
		}
		
		cViewer.add(chromePanel);
		cViewer.add(controlPanel, BorderLayout.NORTH );
		cViewer.setVisible(true);
	}

}
