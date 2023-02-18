package mainApp;

/* At Milestone 1 - 

 * Class ChromsomeViewer displays a Chromosome. It is the GUI for a Chromosome i.e it is responsible for creeating a JFrame 
 * and relevant components.
 * 
 * Respresents visually as a grid of colored squares for 1/0 bits green/black for 1/0 respectively
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ChromosomeViewer extends JComponent {
	private Color background = new Color (30,33,36);
	private Chromosome chrome;

	public ChromosomeViewer(Chromosome newChrome) {
		// TODO Auto-generated constructor stub
		cViewerDriver(newChrome);
	}



	/* This method creates the GUI for viewing a chromosome*/
	
	public void cViewerDriver(Chromosome newChrome) {
		// TODO Auto-generated method stub
		this.chrome = newChrome;
		
		JFrame cViewer = new JFrame();

		final String frameTitle = "Chromosome Viewer";
		final int frameXLoc = 100;
		final int frameYLoc = 200;
		
		cViewer.setTitle(frameTitle);
//		cViewer.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		cViewer.setSize(800, 600);
		cViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int chromeNum = this.chrome.getChromeSize();
		int numRows = 0;
		int lastRow = 0;
		numRows = (chromeNum / 10) + 1;
		lastRow = (chromeNum % 10);
		
		GridLayout grid = new GridLayout(numRows, 10, 3, 3);
		JPanel chromeP = new JPanel(grid);
		
		JPanel controlPanel = new JPanel();
		
		ArrayList<JButton> geneButtons = new ArrayList<JButton>();

		
		ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	if(((AbstractButton) e.getSource()).getText() == "1"){
	            		((JButton) e.getSource()).setText("" + 0);
	            		((JButton) e.getSource()).setBackground(Color.WHITE);
	            	}
	            	else {
	            		((JButton) e.getSource()).setText("" + 1);
	            		((JButton) e.getSource()).setBackground(Color.GREEN);
	            	}
	            }
	        }
	    };
				
		for(int i = 0; i < this.chrome.getChromeSize(); i++) {
			String str = new String();
			if(this.chrome.bits.get(i) == 1) {
				str = "1";
			}
			else {
				str = "0";
			}
			geneButtons.add(new JButton(str));
			geneButtons.get(i).addActionListener(listener);
			
			if(this.chrome.bits.get(i) == 1) {
				geneButtons.get(i).setBackground(Color.GREEN);
			}
			else {
				geneButtons.get(i).setBackground(Color.WHITE);
			}
		}
		
		setButtons(cViewer, geneButtons, chromeP, chromeNum);
		
		JButton mutate = new JButton("Mutate");
		controlPanel.add(mutate);
		
		mutate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newChrome.mutate((double) 10);
				setButtons(cViewer, geneButtons, chromeP, chromeNum);
				System.out.println("mutated!");
			}
		});
		
		JButton loadFile = new JButton("Load file");
		controlPanel.add(loadFile);
		
		loadFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JFrame.setDefaultLookAndFeelDecorated(true);
		        JFrame frame = new JFrame("JComboBox Test");
		        frame.setLayout(new FlowLayout());
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        JButton button = new JButton("Select File");
		        button.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
		        		JFileChooser fileChooser = new JFileChooser();
		        		int returnValue = fileChooser.showOpenDialog(null);
		        		if (returnValue == JFileChooser.APPROVE_OPTION) {
		        			File selectedFile = fileChooser.getSelectedFile();
		        			FileLoader fileL = new FileLoader();
		        			try {
								newChrome.bits = fileL.fileToArray(selectedFile);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		        		}
		        	}
		        });
		        frame.add(button);
		        frame.pack();
		        frame.setVisible(true);    
			}
		});
		
		JButton saveFile = new JButton("Save file");
		controlPanel.add(saveFile);
		
		saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				JFileChooser fileChooser = new JFileChooser();
				JTextArea textArea = new JTextArea(24, 80);
				File file;
			    frame.add(new JScrollPane(textArea));
			    int retval = fileChooser.showSaveDialog(saveFile);
			    if (retval == JFileChooser.APPROVE_OPTION) {
			    	file = fileChooser.getSelectedFile();
			    	if (file == null) {
			    		return;
			    	}
			    	if (!file.getName().toLowerCase().endsWith(".txt")) {
			        	file = new File(file.getParentFile(), file.getName() + ".txt");
			    	}
			    	try {
			    		textArea.write(new OutputStreamWriter(new FileOutputStream(file),
			    				"utf-8"));
			    		Desktop.getDesktop().open(file);
			    	} 
			    	catch (Exception e1) {
			    		e1.printStackTrace();
			    	}	
			    }

				frame.setVisible(true);
			}
		});
		
		cViewer.add(controlPanel, BorderLayout.SOUTH );
		cViewer.pack();
		cViewer.setVisible(true);
	}
	
	// This method creates the gene buttons 
	public void setButtons(JFrame cViewer, ArrayList<JButton> geneButtons,
			 JPanel chromeP, int chromeNum) {


		for(int i = 0; i < chromeNum; i++) {
			if( geneButtons.get(i) != null) {
				geneButtons.set(i, geneButtons.get(i));
				geneButtons.get(i).setText("" + this.chrome.bits.get(i));
				if(this.chrome.bits.get(i) == 1) {
					geneButtons.get(i).setBackground(Color.GREEN);
					chromeP.add(geneButtons.get(i));	
				}
				else {
					geneButtons.get(i).setBackground(Color.WHITE);
					chromeP.add(geneButtons.get(i));
				}
			}
			else {
				continue;
			}
		}
		cViewer.add(chromeP);
}
}
