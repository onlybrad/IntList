package hehexd.gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import hehexd.config.Config;

/**                                  
 * 									
 *  <pre>  +---------------------+  [Add]                           
 *  |Name:   [JTextField] |  [Check]
 *  |Reason: [JTextField] |  [Remove]    
 *  +---------------------+  [Clear]                        
 *                           [List]</pre>
 * @author Only Brad
 *
 */
public class InputArea extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6717912912812108089L;
	
	private final JTextField textName = new JTextField(10); // The input field of the name
	private final JTextField textReason = new JTextField(10); // The input field of the reason
	private final JButton[] buttons = {
		     new JButton("Add"),
			 new JButton("Check"),
			 new JButton("Remove"),
			 new JButton("Clear"),
			 new JButton("List")
			}; // The buttons

	InputArea() {
		
		this.setBackground(Config.getInstance().PANEL_COLOR);
		this.setLayout(new BorderLayout(10,30));
		
		JPanel textAreaPanel = new JPanel(new GridBagLayout()); // Text Panel
		JPanel buttonsAreaPanel = new JPanel(new GridLayout(this.buttons.length,3,5,5)); // Button Panel
		
		JLabel textNameLabel = new JLabel("Name: "); // Label for the text name input
		JLabel textReasonLabel = new JLabel("Reason: "); // Label for the text reason input
		
		/* add a border on both sides and give them a background color */
		this.style(textAreaPanel, buttonsAreaPanel, textNameLabel,textReasonLabel);
		
		/* add the Text Panel and Buttons Panels in the InputPanel */
		this.addPanels(textAreaPanel, buttonsAreaPanel);
		
		/* add TextArea and Button in their respective Panels */
		this.addComponents(textAreaPanel, buttonsAreaPanel, textNameLabel, textReasonLabel);
		
		
		//showAllComponents(this);
	}

	/**
	 * Modify the style of all the panels
	 * 
	 * @param textAreaPanel text area
	 * @param buttonsAreaPanel buttons area
	 * @param textReasonLabel 
	 */
	private void style(JPanel textAreaPanel, JPanel buttonsAreaPanel, JLabel textNameLabel, JLabel textReasonLabel) {
		
		/* style of the text area panel */
		textAreaPanel.setBorder(BorderFactory.createLineBorder(Config.getInstance().BORDER_COLOR, 3, true));
		textAreaPanel.setBackground(Color.WHITE);
		
		/* style of the button area */
		buttonsAreaPanel.setBackground(Config.getInstance().PANEL_COLOR);
		//buttonsAreaPanel.setBorder(new EmptyBorder(0,100,0,100));
							
		/* style of text fields */
		this.textName.setBorder(BorderFactory.createLineBorder(Config.getInstance().BORDER_COLOR));
		this.textReason.setBorder(BorderFactory.createLineBorder(Config.getInstance().BORDER_COLOR));
		textNameLabel.setHorizontalAlignment(JLabel.LEFT);
		textReasonLabel.setHorizontalAlignment(JLabel.LEFT);
		
		this.changeFont(textNameLabel,textReasonLabel);
		
	}
	
	/**
	 * Change the Font of the Labels
	 * 
	 * @param textNameLabel
	 * @param textReasonLabel
	 */
	private void changeFont(JLabel textNameLabel, JLabel textReasonLabel) {
		
		String fontName = this.textName.getFont().getFontName();
		int fontStyle = this.textName.getFont().getStyle();
		int fontSize = this.textName.getFont().getSize();
		Font font = new Font(fontName,fontStyle,(int) (1.5*fontSize));

		this.textName.setFont(font);
		this.textReason.setFont(font);
		textNameLabel.setFont(font);
		textReasonLabel.setFont(font);
	}
	
	/**
	 * Add the text panel and button panel inside the IntputArea panel,
	 * by using a JSplitPane between the left and right sides.
	 * 
	 * @param textAreaPanel
	 * @param buttonsAreaPanel
	 */
	private void addPanels(JPanel textAreaPanel, JPanel buttonsAreaPanel) {
				
		JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,
				textAreaPanel,buttonsAreaPanel);
		horizontalSplitPane.setBackground(Config.getInstance().PANEL_COLOR);
		//horizontalSplitPane.setBorder(new EmptyBorder(0, 150, 0, 100));
		this.add(horizontalSplitPane);
	}
	
	/**
	 * Add the components(buttons and text field) inside their respective panels
	 * 
	 * @param textAreaPanel
	 * @param buttonsAreaPanel
	 * @param textNameLabel
	 * @param textReasonLabel
	 */
	private void addComponents(JPanel textAreaPanel, JPanel buttonsAreaPanel,JLabel textNameLabel, JLabel textReasonLabel) {
		
		this.addText(textAreaPanel, textNameLabel, textReasonLabel);
		this.addButtons(buttonsAreaPanel);
	}
	
	/**
	 * Add the buttons one by one
	 * 
	 * @param buttonsAreaPanel
	 */
	private void addButtons(JPanel buttonsAreaPanel) {
		
		
		/* The grid that contains the button surface is equal to buttons.length(the number of buttons) x 3.
		 * The buttons will be placed in the middle column. This position can be
		 * expressed as 3K-2, where K is an integer. Add null everywhere else.
		 * Example, in 3 x 3 grid, the buttons will go in the position 1, 4 and 7.
		 * 
		 * 1 = 3*1 - 2
		 * 4 = 3*2 - 2
		 * 7 = 3*3 - 2
		 * 
		 * if i is the position, we will test that i+2 % 3 == 0
		 */
		
		for(int i=0;i<buttons.length*3;i++) {
			
			if( (i+2) % 3 == 0)
			
				buttonsAreaPanel.add(this.buttons[(i+2)/3 - 1]);
			
			else
				
				buttonsAreaPanel.add(Box.createHorizontalGlue());
		
		}
		
	}
	
	/**
	 * add the text fields one by one
	 * 
	 * @param textAreaPanel
	 * @param textNameLabel
	 * @param textReasonLabel
	 */
	private void addText(JPanel textAreaPanel, JLabel textNameLabel, JLabel textReasonLabel) {
				
		textNameLabel.setLabelFor(this.textName);
		addInGridBag(textAreaPanel,textNameLabel,0,0,1,1,0.5,0.5,0,new Insets(30,10,30,10));
		addInGridBag(textAreaPanel,this.textName,1,0,1,1,1,1,100,new Insets(30,5,30,50));
		textReasonLabel.setLabelFor(this.textReason);
		addInGridBag(textAreaPanel,textReasonLabel,0,1,1,1,0.5,0.5,0,new Insets(30,10,30,10));
		addInGridBag(textAreaPanel,this.textReason,1,1,1,1,1,1,100,new Insets(30,5,30,50));

	}
	
	/**
	 * Fuck you Java and your stupid Gridbags shenanigans. this is basically a pseudo
	 * GridBagConstraint factory but inside a function. I won't bother explaining what it does,
	 * it's pretty non-gay forward (KappaPride)
	 * 
	 * @param parent
	 * @param component
	 * @param gridx
	 * @param gridy
	 * @param gridwidth
	 * @param gridheight
	 * @param weightx
	 * @param weighty
	 * @param ipadx
	 * @param insets
	 */
	private void addInGridBag(JComponent parent, JComponent component, 
			int gridx, int gridy, int gridwidth, int gridheight, 
			double weightx, double weighty, int ipadx, Insets insets) {
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.weightx = weightx;
		c.weighty = weighty;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = ipadx;
		c.insets = insets;
		
		parent.add(component,c);
		
	}
	
	public JTextField getTextName() {
		
		return this.textName;
	}
	
	public JTextField getTextReason() {
		
		return this.textReason;
	}
	
	public JButton[] getButtons() {
		
		return this.buttons;
	}
	
	
}

