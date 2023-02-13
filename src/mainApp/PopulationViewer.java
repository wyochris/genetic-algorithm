package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import sim.PandemicStatsComponent;
import sim.SimulationComponent;

/**
 * Though nothing is here yet, this class is supposed to show the population and 
 * population fitness graphed over time
 * @author lardnece
 *
 */
public class PopulationViewer {
	
	final int frameXLoc = 1000;
	final int frameYLoc = 500;
	
	public PopulationViewer() {
		JFrame frame = new JFrame();
		frame.setPreferredSize(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(frameXLoc, frameYLoc);
		
		//Create a component for watching simulations
		PopulationViewerComponent popComp = new PopulationViewerComponent();
		frame.add(popComp, BorderLayout.CENTER);
		
		//create a panel for buttons
		JPanel buttonPanel = new JPanel();
		//Set up the panel to use a vertical layout and give it a background color
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground( Color.white );
		
		//create panel to add dropdown and label to
		JPanel dropdownPanel  = new JPanel();
		dropdownPanel.setBackground( Color.WHITE );
		JLabel dropdownLabel = new JLabel("Select number to add: ");
		dropdownPanel.add(dropdownLabel);
		buttonPanel.add(dropdownPanel);
		
		//Modify this if you wish to add different numbers of things into the simulation
		Integer[] numbersForDropdown = {1, 10, 100};
		// create a combo box with the fixed array so you can pick how many things to add
		JComboBox<Integer> addNumberSelector = new JComboBox<Integer>(numbersForDropdown);
		//set its maximum size to be its preferred size so it doesn't get too big
		addNumberSelector.setMaximumSize( addNumberSelector.getPreferredSize() );
		addNumberSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		dropdownPanel.add( addNumberSelector );
		dropdownPanel.setMaximumSize( dropdownPanel.getPreferredSize() );
		
		//Button for adding Particles to a simulation
		JButton addParticles = new JButton("Add Particles");
		addParticles.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//passes in the number from the dropdown list

			} });
		buttonPanel.add( addParticles );
		
		//Button for adding TagPlayers to simulation (includes 1 "it" player)
		JButton addTagPlayers = new JButton("Add TagPlayers");
		addTagPlayers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//passes in the number from the dropdown list

			} });
		buttonPanel.add( addTagPlayers );
		
		Timer t = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				popComp.repaint();
				frame.repaint();
			}
		});
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(start.getText() == "Start") {
					t.start();
					start.setText("Stop");				}
				else {
					t.stop();
					start.setText("Start");
				}
			} });
		buttonPanel.add( start );
		
		// Add button panel on the bottom
		frame.add(buttonPanel, BorderLayout.SOUTH);
				
		//Starts the simulator
		frame.pack();
		frame.setVisible(true);	
	}
	

}
