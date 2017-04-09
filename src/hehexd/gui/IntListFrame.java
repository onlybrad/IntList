package hehexd.gui;

import hehexd.config.Config;
import hehexd.gui.menu.IntListMenuBar;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * 
 * The GUI Frame of the Int List
 * 
 * @author Only Brad
 *
 */
public class IntListFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5960723579614708105L;
	
	/**
	 * The construction of the IntList Frame, the primary GUI interface 
	 * (yes I used Interface twice, shut the fuck up).
	 */
	public IntListFrame() {
		
		super();
		
		/* Creating the input and output panels */
		InputArea inputArea = new InputArea();
		OutputArea outputArea = new OutputArea();
		inputArea.setBorder(new EmptyBorder(25, 0, 0, 0));
		this.getContentPane().setBackground(Color.WHITE);
		
		/* Divide the Frame into 2 pannels, the "Input area" and the "Output Area" */
		this.getContentPane().setLayout(new BorderLayout(25,25));
		this.getContentPane().add(inputArea,Config.getInstance().INPUT);
		this.getContentPane().add(outputArea, Config.getInstance().OUTPUT);
		
		/* Add a Menu Bar */
		this.setJMenuBar(new IntListMenuBar());
		
		this.setSize(Config.getInstance().FRAME_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/* Highlight the components */
		//highlightComponents((JComponent) this.getContentPane());
		

	}
	
	/**
	 * Recursive function used to highlight all the components with a black border. Useful to 
	 * visually see how the components are placed inside the frame.
	 * 
	 * @param jComponent the component whose children are going to be highlighted (black border)
	 */
	@SuppressWarnings("unused")
	private static void highlightComponents(JComponent jComponent) {
		
		for(Component component : jComponent.getComponents()) {
			
			if(component instanceof JComponent)
				
				highlightComponents((JComponent) component);
			
			((JComponent) component).setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}

}
