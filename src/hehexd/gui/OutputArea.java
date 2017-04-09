package hehexd.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultStyledDocument;
import hehexd.config.Config;



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
	
	
	private final JTextPane text = new JTextPane(new DefaultStyledDocument()); // The text area
	
	OutputArea() {
		
		this.text.setEditable(false);
		
		this.setLayout(new BorderLayout(30, 30));
		this.add(this.text,BorderLayout.CENTER);
		this.addBorder();
	
	}
	
	/**
	 * Add a border around the text area
	 */
	private void addBorder() {

		Border border = BorderFactory.createLineBorder(Config.getInstance().BORDER_COLOR,10);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Log");
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		this.text.setBorder(titledBorder);	
	}

	public JTextPane getTextArea() {
		
		return this.text;
	}
	
}
