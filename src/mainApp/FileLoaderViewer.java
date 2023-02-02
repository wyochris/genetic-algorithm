package mainApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class FileLoaderViewer{
	Color background;

	public FileLoaderViewer(Color background) {
		this.background = background;
	}
	
	public String returnFile() throws FileNotFoundException {
		JFrame frame = new JFrame();
		
		final int frameXLoc = 100;
		final int frameYLoc = 200;

		frame.setTitle("Choose a File");
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(this.background);	
		
		
	    final JLabel directoryLabel = new JLabel(" ");
	    directoryLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
	    frame.add(directoryLabel, BorderLayout.NORTH);

	    final JLabel filenameLabel = new JLabel(" ");
	    filenameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
	    frame.add(filenameLabel, BorderLayout.SOUTH);

	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setControlButtonsAreShown(true);
	    frame.add(fileChooser, BorderLayout.CENTER);
	    	    
	    frame.pack();
		frame.setVisible(true);
		
		return "string";
	}
	

}
