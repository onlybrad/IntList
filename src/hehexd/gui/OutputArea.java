package hehexd.gui;

import java.awt.*;
import javax.swing.*;



/**
 * [ Text Area for output ]
 * 
 * @author Only Brad
 *
 */
public class OutputArea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3196768786722599441L;
	
	
	private final JTextArea text = new JTextArea(5000,20);
	
	OutputArea() {
		
		this.setLayout(new BorderLayout(30, 30));
		this.add(this.text,BorderLayout.CENTER);
		this.text.setEditable(false);
		
		this.text.setBorder(BorderFactory.createMatteBorder(5,0,5,0,Color.BLACK));

	}
	
	public JTextArea getTextArea() {
		
		return this.text;
	}
	
}
