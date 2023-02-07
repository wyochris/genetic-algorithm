package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class MainViewer {
	private char currentMode;
	private Color background;
	
	MainViewer() {
		this.background = new Color (30,33,36);
		this.init();
	}
	
	public void viewerDriver() {
		
	}
	
	private void init() {
		
		final String frameTitle = "Choose Your Viewing Option";
		final int frameWidth = 600;
		final int frameHeight = 600;
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		JFrame frame = new JFrame();
		frame.setTitle(frameTitle);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setSize(400, 400);
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(this.background);	
		
		JPanel controlPanel = new JPanel(new BorderLayout());
		JLabel panelTitle = new JLabel("Choose Your Viewing Mode");
		controlPanel.add(panelTitle,BorderLayout.NORTH);
		
		JButton chrome = new JButton("Chromosome Viewer");
		controlPanel.add(chrome);
		
		chrome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileLoader chromeFile = new FileLoader();
				ArrayList<Integer> chromeBits = chromeFile.init();
				Chromosome newChrome = new Chromosome(chromeBits);
				ChromosomeViewer cViewer = new ChromosomeViewer(newChrome, frame);
//				ChromosomeViewer cViewer = new ChromosomeViewer(frame);

				
			}
		});
	
		frame.add(controlPanel, BorderLayout.NORTH );
		frame.setVisible(true);
		
	}
} // driverMain
