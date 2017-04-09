package hehexd.gui;

import java.awt.*;
import javax.swing.*;

import hehexd.config.Config;

/**                                  
 * +---------------------+ [Add]									
 * |Name:   [JTextField] | [Check]            
 * |Reason: [JTextField] | [Remove]                              
 * +---------------------+
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
			 new JButton("Remove")
			}; // The buttons

	InputArea() {
		
		this.setBackground(Config.getInstance().PANEL_COLOR);
		
		/* add the input panels inside a container */
		JPanel container = new JPanel();
		container.setOpaque(false);
		this.setLayout(new BorderLayout(10,30));
		this.add(container,"Center");
		
		JPanel textAreaPanel = new JPanel(new GridBagLayout()); // Text Panel
		JPanel buttonsAreaPanel = new JPanel(new GridLayout(3,3,5,5)); // Button Panel

		JLabel textNameLabel = new JLabel("Name: "); // Label for the text name input
		JLabel textReasonLabel = new JLabel("Reason: "); // Label for the text reason input
		
		/* add a border on both sides and give them a blue background color */
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
		
		//this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

		textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
		textAreaPanel.setBackground(Color.WHITE);
		buttonsAreaPanel.setBackground(Config.getInstance().PANEL_COLOR);
								
		this.textName.setBorder(BorderFactory.createLineBorder(Color.black));
		this.textReason.setBorder(BorderFactory.createLineBorder(Color.black));
		
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
	 * Add the text panel and button panel inside the container of [this]
	 * 
	 * @param textAreaPanel
	 * @param buttonsAreaPanel
	 */
	private void addPanels(JPanel textAreaPanel, JPanel buttonsAreaPanel) {
				
		JPanel buttonsAreaContainer = new JPanel(new FlowLayout(FlowLayout.LEADING, 100, 0));
		JPanel container = (JPanel)this.getComponent(0);
		
		container.add(textAreaPanel);
		container.add(buttonsAreaContainer);
		
		buttonsAreaContainer.add(buttonsAreaPanel);
		buttonsAreaContainer.setBackground(Config.getInstance().PANEL_COLOR);
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
		
		/* top padding in button area */
		//addSpace(buttonsAreaPanel,7);
		/* first button */
		buttonsAreaPanel.add(this.buttons[0]);
		/* padding */
		//addSpace(buttonsAreaPanel,4);
		/* second button */
		buttonsAreaPanel.add(this.buttons[1]);
		/* padding */
		//addSpace(buttonsAreaPanel,4);
		/* third button */
		buttonsAreaPanel.add(this.buttons[2]);
		/* bottom padding in button area */
		//addSpace(buttonsAreaPanel,7);
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
		c.anchor = GridBagConstraints.NORTH;
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

