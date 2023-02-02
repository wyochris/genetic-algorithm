package mainApp;

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

public class ChromosomeViewer extends JComponent {
	private Color background = new Color (30,33,36);
	private Chromosome chromosome;

	public ChromosomeViewer(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated constructor stub
		cViewerDriver(newChrome, frame);
	}

	public void cViewerDriver(Chromosome newChrome, JFrame frame) {
		// TODO Auto-generated method stub
		this.chromosome = newChrome;
		
		frame.removeAll();
		frame.dispose();
		
		JFrame cViewer = new JFrame();
		
		final String frameTitle = "Chromosome Viewer";
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		cViewer.setTitle(frameTitle);
		cViewer.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		frame.setLocation(frameXLoc, frameYLoc);
		cViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cViewer.getContentPane().setBackground(this.background);	
		
		JPanel controlPanel = new JPanel();
		
		JButton mutate = new JButton("Mutate");
		controlPanel.add(mutate);
		
		mutate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
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
		
		for(int i = 0; i < this.chromosome.getChromeSize(); i++) {
			Rectangle2D gene = new Rectangle2D.Double(20 + i *20, 20, 20, 20);
			
		}
		
		cViewer.add(controlPanel, BorderLayout.NORTH );
		cViewer.setVisible(true);
	}

}
