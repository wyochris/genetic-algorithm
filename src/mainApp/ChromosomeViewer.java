/* At Milestone 1 - 

 * Class ChromsomeViewer displays a Chromosome. It is the GUI for a Chromosome i.e it is responsible for creeating a JFrame 
 * and relevant components.
 * 
 * Respresents visually as a grid of colored squares for 1/0 bits green/black for 1/0 respectively
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChromosomeViewer {

	public void cViewerDriver() {
		// TODO Auto-generated method stub
		
		final String frameTitle = "Vehicle Drawing Graphics Question";
		final int frameWidth = 1000;
		final int frameHeight = 600;
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		JFrame frame = new JFrame();
		frame.setTitle(frameTitle);
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel controlPanel = new JPanel();
		
		JButton moveForward = new JButton("Move Forward");
		controlPanel.add(moveForward);
		
		moveForward.addActionListener(new ActionListener() {
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
		
		
		frame.add(controlPanel, BorderLayout.NORTH );
		frame.setVisible(true);
	}

}
