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
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Though nothing is here yet, this class is supposed to show the population and 
 * population fitness graphed over time
 * @author lardnece
 *
 */
public class PopulationViewer extends JComponent {
	
	final int frameXLoc = 500;
	final int frameYLoc = 500;
	
	public PopulationViewer() {
		JFrame frame = new JFrame();
		frame.setPreferredSize(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(frameXLoc, frameYLoc);
		
		//Create a component for watching simulations
		PopulationViewerComponent popComp = new PopulationViewerComponent();
		frame.add(popComp, BorderLayout.NORTH);
		//create a panel for buttons
		JPanel buttonPanel = new JPanel();
		//Set up the panel to use a vertical layout and give it a background color
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBackground( Color.white );
		
		//create panel to add dropdown and label to
		JPanel dropdownPanel  = new JPanel();
		dropdownPanel.setBackground( Color.WHITE );
		JLabel dropdownLabel = new JLabel("Selection: ");
		dropdownPanel.add(dropdownLabel);
		buttonPanel.add(dropdownPanel);
		
		//Modify this if you wish to add different numbers of things into the simulation
		String[] numbersForDropdown = {"Truncation"};
		// create a combo box with the fixed array so you can pick how many things to add
		JComboBox<String> addNumberSelector = new JComboBox<String>(numbersForDropdown);
		//set its maximum size to be its preferred size so it doesn't get too big
		addNumberSelector.setMaximumSize( addNumberSelector.getPreferredSize() );
		addNumberSelector.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		dropdownPanel.add( addNumberSelector );
		dropdownPanel.setMaximumSize( dropdownPanel.getPreferredSize() );
		
		JLabel mutuateRateText = new JLabel("Mutation rate: ");
		buttonPanel.add(mutuateRateText);
		JTextField mutateRate = new JTextField("1.0");
//		numGen.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//passes in the number from the dropdown list
//				
//			} });
		buttonPanel.add( mutateRate );
		
		//Button for adding Particles to a simulation
		JLabel numGenText = new JLabel("Generations: ");
		buttonPanel.add(numGenText);
		JTextField numGen = new JTextField("100");
//		numGen.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//passes in the number from the dropdown list
//				
//			} });
		buttonPanel.add( numGen );
		
		JLabel numPopText = new JLabel("Population: ");
		buttonPanel.add(numPopText);
		JTextField numPop = new JTextField("100");
		buttonPanel.add( numPop );

		
		Timer t = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				popComp.update();
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
					popComp.start(Integer.parseInt(numGen.getText()), 
							Integer.parseInt(numPop.getText()), Double.parseDouble(mutateRate.getText()));
					
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
