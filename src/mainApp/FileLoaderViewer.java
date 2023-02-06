/* At Milestone 1 - 
 * Responsible for Viewing File Loader
 *
 */

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
	Color background = new Color (30,33,36);

	public FileLoaderViewer(Color background) {
		this.background = background;
	}
	
	public File returnFile() throws FileNotFoundException {
		JFrame frame = new JFrame();
		
		final int frameXLoc = 100;
		final int frameYLoc = 200;

		frame.setTitle("Choose a File");
		frame.setLocation(frameXLoc, frameYLoc);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(this.background);	

	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setControlButtonsAreShown(true);
	    fileChooser.setFileView(null);
	    File file = fileChooser.getSelectedFile();
	   
	    frame.add(fileChooser, BorderLayout.CENTER);
	    	    
	    frame.pack();
		frame.setVisible(true);
		return file;
	}

	public File init() {
		// TODO Auto-generated method stub
		File file = new File("twenty.txt");
		return file;
	}
	

}
